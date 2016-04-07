package com.hytx.service.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.system.ex.RoleMenuAuthMapperEx;
import com.hytx.dao.system.ori.MenuAuthMapper;
import com.hytx.dao.system.ori.MenuMapper;
import com.hytx.dao.system.ori.RoleMenuAuthMapper;
import com.hytx.dto.system.MenuAuthDto;
import com.hytx.dto.system.MenuNodeDto;
import com.hytx.model.system.Menu;
import com.hytx.model.system.MenuExample;
import com.hytx.model.system.RoleMenuAuth;
import com.hytx.model.system.RoleMenuAuthExample;
import com.hytx.model.system.User;

@Service("roleMenuAuthServiceImpl")
public class RoleMenuAuthServiceImpl implements IRoleMenuAuthService {
	@Autowired
	private RoleMenuAuthMapper roleMenuAuthMapper;
	@Autowired
	private RoleMenuAuthMapperEx roleMenuAuthMapperEx;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private MenuAuthMapper menuAuthMapper;

	public MenuNodeDto selectMenuNodeDtoList(Integer roleId){
		 Map<Integer,MenuNodeDto>map=new HashMap<Integer,MenuNodeDto>();
		 MenuExample example=new MenuExample();
		 example.setOrderByClause("tier asc,orderNum asc");
		 List<Menu>menuList= menuMapper.selectByExample(example); 
		 List<MenuAuthDto>authDtoList= roleMenuAuthMapperEx.selectRoleMenuAuthList(roleId);
		 MenuNodeDto rootDto=new MenuNodeDto();
		 rootDto.setText("管理后台");
		 rootDto.setId(0);
		 rootDto.getAttributes().put("isLeaf", 0);
		 map.put(0, rootDto);
		 for(Menu m:menuList){
			 MenuNodeDto dto=new MenuNodeDto();
			 dto.setId(m.getId());
			 dto.setText(m.getName());
			 dto.setState("closed");
			 dto.getAttributes().put("isLeaf", 0);			 
			 MenuNodeDto parentDto = map.get(m.getPid());
			 if(parentDto!=null){
				 parentDto.getChildren().add(dto);
				 map.put(dto.getId(), dto);
			 }
		 }
		 for(MenuAuthDto mad:authDtoList){
			 MenuNodeDto parentDto = map.get(mad.getMenuId());
			 if(parentDto!=null){
				 MenuNodeDto dto=new MenuNodeDto(); 
				 dto.setId(mad.getId());
				 dto.setText(mad.getAuthName());
				 dto.setState("open");
				 dto.setIconCls("tree_node_icon_none");
				 dto.getAttributes().put("isLeaf", 1);
				 if(mad.getRoleId()!=null&&mad.getRoleId()>0){
					dto.setChecked("checked"); 
				 }
				 parentDto.getChildren().add(dto);
				 parentDto.setState("open");
			 }
		 }
	     return rootDto;
	}

	public List<MenuAuthDto> selectMenuAuthList(Integer menuId){
		return roleMenuAuthMapperEx.selectMenuAuthList(menuId);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateRoleMenuAuths(Integer roleId,List<Integer>menuAuthIdList,User user){
		RoleMenuAuthExample example=new RoleMenuAuthExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		roleMenuAuthMapper.deleteByExample(example);
		for(Integer maId:menuAuthIdList){
			RoleMenuAuth rma=new RoleMenuAuth();
			rma.setMenuAuthId(maId);
			rma.setRoleId(roleId);
			rma.setCreateBy(user.getUserName());
			rma.setCreateDt(new Date());
			roleMenuAuthMapper.insert(rma);
		}
		return menuAuthIdList.size();
	}
	
	public  List<MenuAuthDto> selectUserMenuAuthList(User user){
		return  roleMenuAuthMapperEx.selectUserMenuAuthList(user.getId());
	}
	
	
}
