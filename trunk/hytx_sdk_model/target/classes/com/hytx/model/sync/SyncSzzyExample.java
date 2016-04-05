package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncSzzyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncSzzyExample() {
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andLinkidIsNull() {
            addCriterion("LINKID is null");
            return (Criteria) this;
        }

        public Criteria andLinkidIsNotNull() {
            addCriterion("LINKID is not null");
            return (Criteria) this;
        }

        public Criteria andLinkidEqualTo(String value) {
            addCriterion("LINKID =", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidNotEqualTo(String value) {
            addCriterion("LINKID <>", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidGreaterThan(String value) {
            addCriterion("LINKID >", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidGreaterThanOrEqualTo(String value) {
            addCriterion("LINKID >=", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidLessThan(String value) {
            addCriterion("LINKID <", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidLessThanOrEqualTo(String value) {
            addCriterion("LINKID <=", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidLike(String value) {
            addCriterion("LINKID like", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidNotLike(String value) {
            addCriterion("LINKID not like", value, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidIn(List<String> values) {
            addCriterion("LINKID in", values, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidNotIn(List<String> values) {
            addCriterion("LINKID not in", values, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidBetween(String value1, String value2) {
            addCriterion("LINKID between", value1, value2, "linkid");
            return (Criteria) this;
        }

        public Criteria andLinkidNotBetween(String value1, String value2) {
            addCriterion("LINKID not between", value1, value2, "linkid");
            return (Criteria) this;
        }

        public Criteria andInstructionIsNull() {
            addCriterion("INSTRUCTION is null");
            return (Criteria) this;
        }

        public Criteria andInstructionIsNotNull() {
            addCriterion("INSTRUCTION is not null");
            return (Criteria) this;
        }

        public Criteria andInstructionEqualTo(String value) {
            addCriterion("INSTRUCTION =", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotEqualTo(String value) {
            addCriterion("INSTRUCTION <>", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionGreaterThan(String value) {
            addCriterion("INSTRUCTION >", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("INSTRUCTION >=", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLessThan(String value) {
            addCriterion("INSTRUCTION <", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLessThanOrEqualTo(String value) {
            addCriterion("INSTRUCTION <=", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionLike(String value) {
            addCriterion("INSTRUCTION like", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotLike(String value) {
            addCriterion("INSTRUCTION not like", value, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionIn(List<String> values) {
            addCriterion("INSTRUCTION in", values, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotIn(List<String> values) {
            addCriterion("INSTRUCTION not in", values, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionBetween(String value1, String value2) {
            addCriterion("INSTRUCTION between", value1, value2, "instruction");
            return (Criteria) this;
        }

        public Criteria andInstructionNotBetween(String value1, String value2) {
            addCriterion("INSTRUCTION not between", value1, value2, "instruction");
            return (Criteria) this;
        }

        public Criteria andMobIsNull() {
            addCriterion("MOB is null");
            return (Criteria) this;
        }

        public Criteria andMobIsNotNull() {
            addCriterion("MOB is not null");
            return (Criteria) this;
        }

        public Criteria andMobEqualTo(String value) {
            addCriterion("MOB =", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobNotEqualTo(String value) {
            addCriterion("MOB <>", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobGreaterThan(String value) {
            addCriterion("MOB >", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobGreaterThanOrEqualTo(String value) {
            addCriterion("MOB >=", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobLessThan(String value) {
            addCriterion("MOB <", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobLessThanOrEqualTo(String value) {
            addCriterion("MOB <=", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobLike(String value) {
            addCriterion("MOB like", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobNotLike(String value) {
            addCriterion("MOB not like", value, "mob");
            return (Criteria) this;
        }

        public Criteria andMobIn(List<String> values) {
            addCriterion("MOB in", values, "mob");
            return (Criteria) this;
        }

        public Criteria andMobNotIn(List<String> values) {
            addCriterion("MOB not in", values, "mob");
            return (Criteria) this;
        }

        public Criteria andMobBetween(String value1, String value2) {
            addCriterion("MOB between", value1, value2, "mob");
            return (Criteria) this;
        }

        public Criteria andMobNotBetween(String value1, String value2) {
            addCriterion("MOB not between", value1, value2, "mob");
            return (Criteria) this;
        }

        public Criteria andDestmobIsNull() {
            addCriterion("DESTMOB is null");
            return (Criteria) this;
        }

        public Criteria andDestmobIsNotNull() {
            addCriterion("DESTMOB is not null");
            return (Criteria) this;
        }

        public Criteria andDestmobEqualTo(String value) {
            addCriterion("DESTMOB =", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobNotEqualTo(String value) {
            addCriterion("DESTMOB <>", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobGreaterThan(String value) {
            addCriterion("DESTMOB >", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobGreaterThanOrEqualTo(String value) {
            addCriterion("DESTMOB >=", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobLessThan(String value) {
            addCriterion("DESTMOB <", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobLessThanOrEqualTo(String value) {
            addCriterion("DESTMOB <=", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobLike(String value) {
            addCriterion("DESTMOB like", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobNotLike(String value) {
            addCriterion("DESTMOB not like", value, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobIn(List<String> values) {
            addCriterion("DESTMOB in", values, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobNotIn(List<String> values) {
            addCriterion("DESTMOB not in", values, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobBetween(String value1, String value2) {
            addCriterion("DESTMOB between", value1, value2, "destmob");
            return (Criteria) this;
        }

        public Criteria andDestmobNotBetween(String value1, String value2) {
            addCriterion("DESTMOB not between", value1, value2, "destmob");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCpparamIsNull() {
            addCriterion("CPPARAM is null");
            return (Criteria) this;
        }

        public Criteria andCpparamIsNotNull() {
            addCriterion("CPPARAM is not null");
            return (Criteria) this;
        }

        public Criteria andCpparamEqualTo(String value) {
            addCriterion("CPPARAM =", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotEqualTo(String value) {
            addCriterion("CPPARAM <>", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamGreaterThan(String value) {
            addCriterion("CPPARAM >", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamGreaterThanOrEqualTo(String value) {
            addCriterion("CPPARAM >=", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLessThan(String value) {
            addCriterion("CPPARAM <", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLessThanOrEqualTo(String value) {
            addCriterion("CPPARAM <=", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLike(String value) {
            addCriterion("CPPARAM like", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotLike(String value) {
            addCriterion("CPPARAM not like", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamIn(List<String> values) {
            addCriterion("CPPARAM in", values, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotIn(List<String> values) {
            addCriterion("CPPARAM not in", values, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamBetween(String value1, String value2) {
            addCriterion("CPPARAM between", value1, value2, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotBetween(String value1, String value2) {
            addCriterion("CPPARAM not between", value1, value2, "cpparam");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("PROVINCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("PROVINCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("PROVINCE_NAME =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("PROVINCE_NAME <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("PROVINCE_NAME >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("PROVINCE_NAME <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("PROVINCE_NAME like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("PROVINCE_NAME not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("PROVINCE_NAME in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("PROVINCE_NAME not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andRptStatIsNull() {
            addCriterion("RPT_STAT is null");
            return (Criteria) this;
        }

        public Criteria andRptStatIsNotNull() {
            addCriterion("RPT_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andRptStatEqualTo(String value) {
            addCriterion("RPT_STAT =", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatNotEqualTo(String value) {
            addCriterion("RPT_STAT <>", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatGreaterThan(String value) {
            addCriterion("RPT_STAT >", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_STAT >=", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatLessThan(String value) {
            addCriterion("RPT_STAT <", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatLessThanOrEqualTo(String value) {
            addCriterion("RPT_STAT <=", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatLike(String value) {
            addCriterion("RPT_STAT like", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatNotLike(String value) {
            addCriterion("RPT_STAT not like", value, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatIn(List<String> values) {
            addCriterion("RPT_STAT in", values, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatNotIn(List<String> values) {
            addCriterion("RPT_STAT not in", values, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatBetween(String value1, String value2) {
            addCriterion("RPT_STAT between", value1, value2, "rptStat");
            return (Criteria) this;
        }

        public Criteria andRptStatNotBetween(String value1, String value2) {
            addCriterion("RPT_STAT not between", value1, value2, "rptStat");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIsNull() {
            addCriterion("SYNC_ALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIsNotNull() {
            addCriterion("SYNC_ALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdEqualTo(String value) {
            addCriterion("SYNC_ALL_ID =", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotEqualTo(String value) {
            addCriterion("SYNC_ALL_ID <>", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThan(String value) {
            addCriterion("SYNC_ALL_ID >", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYNC_ALL_ID >=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThan(String value) {
            addCriterion("SYNC_ALL_ID <", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThanOrEqualTo(String value) {
            addCriterion("SYNC_ALL_ID <=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLike(String value) {
            addCriterion("SYNC_ALL_ID like", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotLike(String value) {
            addCriterion("SYNC_ALL_ID not like", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIn(List<String> values) {
            addCriterion("SYNC_ALL_ID in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotIn(List<String> values) {
            addCriterion("SYNC_ALL_ID not in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdBetween(String value1, String value2) {
            addCriterion("SYNC_ALL_ID between", value1, value2, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotBetween(String value1, String value2) {
            addCriterion("SYNC_ALL_ID not between", value1, value2, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andDtIsNull() {
            addCriterion("DT is null");
            return (Criteria) this;
        }

        public Criteria andDtIsNotNull() {
            addCriterion("DT is not null");
            return (Criteria) this;
        }

        public Criteria andDtEqualTo(String value) {
            addCriterion("DT =", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotEqualTo(String value) {
            addCriterion("DT <>", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThan(String value) {
            addCriterion("DT >", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThanOrEqualTo(String value) {
            addCriterion("DT >=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThan(String value) {
            addCriterion("DT <", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThanOrEqualTo(String value) {
            addCriterion("DT <=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLike(String value) {
            addCriterion("DT like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotLike(String value) {
            addCriterion("DT not like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtIn(List<String> values) {
            addCriterion("DT in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotIn(List<String> values) {
            addCriterion("DT not in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtBetween(String value1, String value2) {
            addCriterion("DT between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotBetween(String value1, String value2) {
            addCriterion("DT not between", value1, value2, "dt");
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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