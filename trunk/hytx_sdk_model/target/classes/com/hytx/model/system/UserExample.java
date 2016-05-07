package com.hytx.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLoginNameIsNull() {
			addCriterion("LOGIN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andLoginNameIsNotNull() {
			addCriterion("LOGIN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andLoginNameEqualTo(String value) {
			addCriterion("LOGIN_NAME =", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotEqualTo(String value) {
			addCriterion("LOGIN_NAME <>", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameGreaterThan(String value) {
			addCriterion("LOGIN_NAME >", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
			addCriterion("LOGIN_NAME >=", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLessThan(String value) {
			addCriterion("LOGIN_NAME <", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLessThanOrEqualTo(String value) {
			addCriterion("LOGIN_NAME <=", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLike(String value) {
			addCriterion("LOGIN_NAME like", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotLike(String value) {
			addCriterion("LOGIN_NAME not like", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameIn(List<String> values) {
			addCriterion("LOGIN_NAME in", values, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotIn(List<String> values) {
			addCriterion("LOGIN_NAME not in", values, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameBetween(String value1, String value2) {
			addCriterion("LOGIN_NAME between", value1, value2, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotBetween(String value1, String value2) {
			addCriterion("LOGIN_NAME not between", value1, value2, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginPwdIsNull() {
			addCriterion("LOGIN_PWD is null");
			return (Criteria) this;
		}

		public Criteria andLoginPwdIsNotNull() {
			addCriterion("LOGIN_PWD is not null");
			return (Criteria) this;
		}

		public Criteria andLoginPwdEqualTo(String value) {
			addCriterion("LOGIN_PWD =", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdNotEqualTo(String value) {
			addCriterion("LOGIN_PWD <>", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdGreaterThan(String value) {
			addCriterion("LOGIN_PWD >", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdGreaterThanOrEqualTo(String value) {
			addCriterion("LOGIN_PWD >=", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdLessThan(String value) {
			addCriterion("LOGIN_PWD <", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdLessThanOrEqualTo(String value) {
			addCriterion("LOGIN_PWD <=", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdLike(String value) {
			addCriterion("LOGIN_PWD like", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdNotLike(String value) {
			addCriterion("LOGIN_PWD not like", value, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdIn(List<String> values) {
			addCriterion("LOGIN_PWD in", values, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdNotIn(List<String> values) {
			addCriterion("LOGIN_PWD not in", values, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdBetween(String value1, String value2) {
			addCriterion("LOGIN_PWD between", value1, value2, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andLoginPwdNotBetween(String value1, String value2) {
			addCriterion("LOGIN_PWD not between", value1, value2, "loginPwd");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("STATUS =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("STATUS <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("STATUS >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("STATUS >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("STATUS <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("STATUS <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("STATUS in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("STATUS not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andMemoIsNull() {
			addCriterion("MEMO is null");
			return (Criteria) this;
		}

		public Criteria andMemoIsNotNull() {
			addCriterion("MEMO is not null");
			return (Criteria) this;
		}

		public Criteria andMemoEqualTo(String value) {
			addCriterion("MEMO =", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoNotEqualTo(String value) {
			addCriterion("MEMO <>", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoGreaterThan(String value) {
			addCriterion("MEMO >", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoGreaterThanOrEqualTo(String value) {
			addCriterion("MEMO >=", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoLessThan(String value) {
			addCriterion("MEMO <", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoLessThanOrEqualTo(String value) {
			addCriterion("MEMO <=", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoLike(String value) {
			addCriterion("MEMO like", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoNotLike(String value) {
			addCriterion("MEMO not like", value, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoIn(List<String> values) {
			addCriterion("MEMO in", values, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoNotIn(List<String> values) {
			addCriterion("MEMO not in", values, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoBetween(String value1, String value2) {
			addCriterion("MEMO between", value1, value2, "memo");
			return (Criteria) this;
		}

		public Criteria andMemoNotBetween(String value1, String value2) {
			addCriterion("MEMO not between", value1, value2, "memo");
			return (Criteria) this;
		}

		public Criteria andCreateDtIsNull() {
			addCriterion("CREATE_DT is null");
			return (Criteria) this;
		}

		public Criteria andCreateDtIsNotNull() {
			addCriterion("CREATE_DT is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDtEqualTo(Date value) {
			addCriterion("CREATE_DT =", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtNotEqualTo(Date value) {
			addCriterion("CREATE_DT <>", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtGreaterThan(Date value) {
			addCriterion("CREATE_DT >", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_DT >=", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtLessThan(Date value) {
			addCriterion("CREATE_DT <", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_DT <=", value, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtIn(List<Date> values) {
			addCriterion("CREATE_DT in", values, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtNotIn(List<Date> values) {
			addCriterion("CREATE_DT not in", values, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtBetween(Date value1, Date value2) {
			addCriterion("CREATE_DT between", value1, value2, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateDtNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_DT not between", value1, value2, "createDt");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNull() {
			addCriterion("CREATE_BY is null");
			return (Criteria) this;
		}

		public Criteria andCreateByIsNotNull() {
			addCriterion("CREATE_BY is not null");
			return (Criteria) this;
		}

		public Criteria andCreateByEqualTo(String value) {
			addCriterion("CREATE_BY =", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotEqualTo(String value) {
			addCriterion("CREATE_BY <>", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThan(String value) {
			addCriterion("CREATE_BY >", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_BY >=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThan(String value) {
			addCriterion("CREATE_BY <", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLessThanOrEqualTo(String value) {
			addCriterion("CREATE_BY <=", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByLike(String value) {
			addCriterion("CREATE_BY like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotLike(String value) {
			addCriterion("CREATE_BY not like", value, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByIn(List<String> values) {
			addCriterion("CREATE_BY in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotIn(List<String> values) {
			addCriterion("CREATE_BY not in", values, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByBetween(String value1, String value2) {
			addCriterion("CREATE_BY between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andCreateByNotBetween(String value1, String value2) {
			addCriterion("CREATE_BY not between", value1, value2, "createBy");
			return (Criteria) this;
		}

		public Criteria andUpdateDtIsNull() {
			addCriterion("UPDATE_DT is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDtIsNotNull() {
			addCriterion("UPDATE_DT is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDtEqualTo(Date value) {
			addCriterion("UPDATE_DT =", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtNotEqualTo(Date value) {
			addCriterion("UPDATE_DT <>", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtGreaterThan(Date value) {
			addCriterion("UPDATE_DT >", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_DT >=", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtLessThan(Date value) {
			addCriterion("UPDATE_DT <", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_DT <=", value, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtIn(List<Date> values) {
			addCriterion("UPDATE_DT in", values, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtNotIn(List<Date> values) {
			addCriterion("UPDATE_DT not in", values, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtBetween(Date value1, Date value2) {
			addCriterion("UPDATE_DT between", value1, value2, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateDtNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_DT not between", value1, value2, "updateDt");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNull() {
			addCriterion("UPDATE_BY is null");
			return (Criteria) this;
		}

		public Criteria andUpdateByIsNotNull() {
			addCriterion("UPDATE_BY is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateByEqualTo(String value) {
			addCriterion("UPDATE_BY =", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotEqualTo(String value) {
			addCriterion("UPDATE_BY <>", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThan(String value) {
			addCriterion("UPDATE_BY >", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_BY >=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThan(String value) {
			addCriterion("UPDATE_BY <", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_BY <=", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByLike(String value) {
			addCriterion("UPDATE_BY like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotLike(String value) {
			addCriterion("UPDATE_BY not like", value, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByIn(List<String> values) {
			addCriterion("UPDATE_BY in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotIn(List<String> values) {
			addCriterion("UPDATE_BY not in", values, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByBetween(String value1, String value2) {
			addCriterion("UPDATE_BY between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andUpdateByNotBetween(String value1, String value2) {
			addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
			return (Criteria) this;
		}

		public Criteria andLinkManIsNull() {
			addCriterion("LINK_MAN is null");
			return (Criteria) this;
		}

		public Criteria andLinkManIsNotNull() {
			addCriterion("LINK_MAN is not null");
			return (Criteria) this;
		}

		public Criteria andLinkManEqualTo(String value) {
			addCriterion("LINK_MAN =", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotEqualTo(String value) {
			addCriterion("LINK_MAN <>", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManGreaterThan(String value) {
			addCriterion("LINK_MAN >", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManGreaterThanOrEqualTo(String value) {
			addCriterion("LINK_MAN >=", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLessThan(String value) {
			addCriterion("LINK_MAN <", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLessThanOrEqualTo(String value) {
			addCriterion("LINK_MAN <=", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManLike(String value) {
			addCriterion("LINK_MAN like", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotLike(String value) {
			addCriterion("LINK_MAN not like", value, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManIn(List<String> values) {
			addCriterion("LINK_MAN in", values, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotIn(List<String> values) {
			addCriterion("LINK_MAN not in", values, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManBetween(String value1, String value2) {
			addCriterion("LINK_MAN between", value1, value2, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkManNotBetween(String value1, String value2) {
			addCriterion("LINK_MAN not between", value1, value2, "linkMan");
			return (Criteria) this;
		}

		public Criteria andLinkQqIsNull() {
			addCriterion("LINK_QQ is null");
			return (Criteria) this;
		}

		public Criteria andLinkQqIsNotNull() {
			addCriterion("LINK_QQ is not null");
			return (Criteria) this;
		}

		public Criteria andLinkQqEqualTo(String value) {
			addCriterion("LINK_QQ =", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotEqualTo(String value) {
			addCriterion("LINK_QQ <>", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqGreaterThan(String value) {
			addCriterion("LINK_QQ >", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqGreaterThanOrEqualTo(String value) {
			addCriterion("LINK_QQ >=", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLessThan(String value) {
			addCriterion("LINK_QQ <", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLessThanOrEqualTo(String value) {
			addCriterion("LINK_QQ <=", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqLike(String value) {
			addCriterion("LINK_QQ like", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotLike(String value) {
			addCriterion("LINK_QQ not like", value, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqIn(List<String> values) {
			addCriterion("LINK_QQ in", values, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotIn(List<String> values) {
			addCriterion("LINK_QQ not in", values, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqBetween(String value1, String value2) {
			addCriterion("LINK_QQ between", value1, value2, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkQqNotBetween(String value1, String value2) {
			addCriterion("LINK_QQ not between", value1, value2, "linkQq");
			return (Criteria) this;
		}

		public Criteria andLinkMobileIsNull() {
			addCriterion("LINK_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andLinkMobileIsNotNull() {
			addCriterion("LINK_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkMobileEqualTo(String value) {
			addCriterion("LINK_MOBILE =", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileNotEqualTo(String value) {
			addCriterion("LINK_MOBILE <>", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileGreaterThan(String value) {
			addCriterion("LINK_MOBILE >", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileGreaterThanOrEqualTo(String value) {
			addCriterion("LINK_MOBILE >=", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileLessThan(String value) {
			addCriterion("LINK_MOBILE <", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileLessThanOrEqualTo(String value) {
			addCriterion("LINK_MOBILE <=", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileLike(String value) {
			addCriterion("LINK_MOBILE like", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileNotLike(String value) {
			addCriterion("LINK_MOBILE not like", value, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileIn(List<String> values) {
			addCriterion("LINK_MOBILE in", values, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileNotIn(List<String> values) {
			addCriterion("LINK_MOBILE not in", values, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileBetween(String value1, String value2) {
			addCriterion("LINK_MOBILE between", value1, value2, "linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkMobileNotBetween(String value1, String value2) {
			addCriterion("LINK_MOBILE not between", value1, value2,
					"linkMobile");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIsNull() {
			addCriterion("LINK_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIsNotNull() {
			addCriterion("LINK_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andLinkEmailEqualTo(String value) {
			addCriterion("LINK_EMAIL =", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotEqualTo(String value) {
			addCriterion("LINK_EMAIL <>", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailGreaterThan(String value) {
			addCriterion("LINK_EMAIL >", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailGreaterThanOrEqualTo(String value) {
			addCriterion("LINK_EMAIL >=", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLessThan(String value) {
			addCriterion("LINK_EMAIL <", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLessThanOrEqualTo(String value) {
			addCriterion("LINK_EMAIL <=", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailLike(String value) {
			addCriterion("LINK_EMAIL like", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotLike(String value) {
			addCriterion("LINK_EMAIL not like", value, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailIn(List<String> values) {
			addCriterion("LINK_EMAIL in", values, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotIn(List<String> values) {
			addCriterion("LINK_EMAIL not in", values, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailBetween(String value1, String value2) {
			addCriterion("LINK_EMAIL between", value1, value2, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andLinkEmailNotBetween(String value1, String value2) {
			addCriterion("LINK_EMAIL not between", value1, value2, "linkEmail");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNull() {
			addCriterion("USER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("USER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Integer value) {
			addCriterion("USER_TYPE =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Integer value) {
			addCriterion("USER_TYPE <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Integer value) {
			addCriterion("USER_TYPE >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_TYPE >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Integer value) {
			addCriterion("USER_TYPE <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
			addCriterion("USER_TYPE <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Integer> values) {
			addCriterion("USER_TYPE in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Integer> values) {
			addCriterion("USER_TYPE not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Integer value1, Integer value2) {
			addCriterion("USER_TYPE between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_TYPE not between", value1, value2, "userType");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}