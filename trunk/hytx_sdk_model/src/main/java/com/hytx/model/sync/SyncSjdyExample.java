package com.hytx.model.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncSjdyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncSjdyExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(Long value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(Long value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(Long value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(Long value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(Long value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(Long value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<Long> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<Long> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(Long value1, Long value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(Long value1, Long value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andSpNumberIsNull() {
            addCriterion("SP_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSpNumberIsNotNull() {
            addCriterion("SP_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSpNumberEqualTo(String value) {
            addCriterion("SP_NUMBER =", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotEqualTo(String value) {
            addCriterion("SP_NUMBER <>", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberGreaterThan(String value) {
            addCriterion("SP_NUMBER >", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberGreaterThanOrEqualTo(String value) {
            addCriterion("SP_NUMBER >=", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLessThan(String value) {
            addCriterion("SP_NUMBER <", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLessThanOrEqualTo(String value) {
            addCriterion("SP_NUMBER <=", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLike(String value) {
            addCriterion("SP_NUMBER like", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotLike(String value) {
            addCriterion("SP_NUMBER not like", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberIn(List<String> values) {
            addCriterion("SP_NUMBER in", values, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotIn(List<String> values) {
            addCriterion("SP_NUMBER not in", values, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberBetween(String value1, String value2) {
            addCriterion("SP_NUMBER between", value1, value2, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotBetween(String value1, String value2) {
            addCriterion("SP_NUMBER not between", value1, value2, "spNumber");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNull() {
            addCriterion("MO_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNotNull() {
            addCriterion("MO_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMoContentEqualTo(String value) {
            addCriterion("MO_CONTENT =", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotEqualTo(String value) {
            addCriterion("MO_CONTENT <>", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThan(String value) {
            addCriterion("MO_CONTENT >", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThanOrEqualTo(String value) {
            addCriterion("MO_CONTENT >=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThan(String value) {
            addCriterion("MO_CONTENT <", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThanOrEqualTo(String value) {
            addCriterion("MO_CONTENT <=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLike(String value) {
            addCriterion("MO_CONTENT like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotLike(String value) {
            addCriterion("MO_CONTENT not like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentIn(List<String> values) {
            addCriterion("MO_CONTENT in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotIn(List<String> values) {
            addCriterion("MO_CONTENT not in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentBetween(String value1, String value2) {
            addCriterion("MO_CONTENT between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotBetween(String value1, String value2) {
            addCriterion("MO_CONTENT not between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNull() {
            addCriterion("LINK_ID is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("LINK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(String value) {
            addCriterion("LINK_ID =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(String value) {
            addCriterion("LINK_ID <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(String value) {
            addCriterion("LINK_ID >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_ID >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(String value) {
            addCriterion("LINK_ID <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(String value) {
            addCriterion("LINK_ID <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLike(String value) {
            addCriterion("LINK_ID like", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotLike(String value) {
            addCriterion("LINK_ID not like", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<String> values) {
            addCriterion("LINK_ID in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<String> values) {
            addCriterion("LINK_ID not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(String value1, String value2) {
            addCriterion("LINK_ID between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(String value1, String value2) {
            addCriterion("LINK_ID not between", value1, value2, "linkId");
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

        public Criteria andSpParamIsNull() {
            addCriterion("SP_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andSpParamIsNotNull() {
            addCriterion("SP_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andSpParamEqualTo(String value) {
            addCriterion("SP_PARAM =", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamNotEqualTo(String value) {
            addCriterion("SP_PARAM <>", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamGreaterThan(String value) {
            addCriterion("SP_PARAM >", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamGreaterThanOrEqualTo(String value) {
            addCriterion("SP_PARAM >=", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamLessThan(String value) {
            addCriterion("SP_PARAM <", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamLessThanOrEqualTo(String value) {
            addCriterion("SP_PARAM <=", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamLike(String value) {
            addCriterion("SP_PARAM like", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamNotLike(String value) {
            addCriterion("SP_PARAM not like", value, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamIn(List<String> values) {
            addCriterion("SP_PARAM in", values, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamNotIn(List<String> values) {
            addCriterion("SP_PARAM not in", values, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamBetween(String value1, String value2) {
            addCriterion("SP_PARAM between", value1, value2, "spParam");
            return (Criteria) this;
        }

        public Criteria andSpParamNotBetween(String value1, String value2) {
            addCriterion("SP_PARAM not between", value1, value2, "spParam");
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

        public Criteria andSyncAllIdIsNull() {
            addCriterion("SYNC_ALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIsNotNull() {
            addCriterion("SYNC_ALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdEqualTo(BigDecimal value) {
            addCriterion("SYNC_ALL_ID =", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotEqualTo(BigDecimal value) {
            addCriterion("SYNC_ALL_ID <>", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThan(BigDecimal value) {
            addCriterion("SYNC_ALL_ID >", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SYNC_ALL_ID >=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThan(BigDecimal value) {
            addCriterion("SYNC_ALL_ID <", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SYNC_ALL_ID <=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIn(List<BigDecimal> values) {
            addCriterion("SYNC_ALL_ID in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotIn(List<BigDecimal> values) {
            addCriterion("SYNC_ALL_ID not in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SYNC_ALL_ID between", value1, value2, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SYNC_ALL_ID not between", value1, value2, "syncAllId");
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

        public Criteria andCityNameIsNull() {
            addCriterion("CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("CITY_NAME =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("CITY_NAME <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("CITY_NAME >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NAME >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("CITY_NAME <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("CITY_NAME <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("CITY_NAME like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("CITY_NAME not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("CITY_NAME in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("CITY_NAME not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("CITY_NAME between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("CITY_NAME not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andTelTypeIsNull() {
            addCriterion("TEL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTelTypeIsNotNull() {
            addCriterion("TEL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTelTypeEqualTo(Integer value) {
            addCriterion("TEL_TYPE =", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeNotEqualTo(Integer value) {
            addCriterion("TEL_TYPE <>", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeGreaterThan(Integer value) {
            addCriterion("TEL_TYPE >", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TEL_TYPE >=", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeLessThan(Integer value) {
            addCriterion("TEL_TYPE <", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TEL_TYPE <=", value, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeIn(List<Integer> values) {
            addCriterion("TEL_TYPE in", values, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeNotIn(List<Integer> values) {
            addCriterion("TEL_TYPE not in", values, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeBetween(Integer value1, Integer value2) {
            addCriterion("TEL_TYPE between", value1, value2, "telType");
            return (Criteria) this;
        }

        public Criteria andTelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TEL_TYPE not between", value1, value2, "telType");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIsNull() {
            addCriterion("FEE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIsNotNull() {
            addCriterion("FEE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeEqualTo(Integer value) {
            addCriterion("FEE_CODE =", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotEqualTo(Integer value) {
            addCriterion("FEE_CODE <>", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThan(Integer value) {
            addCriterion("FEE_CODE >", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_CODE >=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThan(Integer value) {
            addCriterion("FEE_CODE <", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_CODE <=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIn(List<Integer> values) {
            addCriterion("FEE_CODE in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotIn(List<Integer> values) {
            addCriterion("FEE_CODE not in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeBetween(Integer value1, Integer value2) {
            addCriterion("FEE_CODE between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_CODE not between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andRptTimeIsNull() {
            addCriterion("RPT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRptTimeIsNotNull() {
            addCriterion("RPT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRptTimeEqualTo(String value) {
            addCriterion("RPT_TIME =", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeNotEqualTo(String value) {
            addCriterion("RPT_TIME <>", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeGreaterThan(String value) {
            addCriterion("RPT_TIME >", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_TIME >=", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeLessThan(String value) {
            addCriterion("RPT_TIME <", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeLessThanOrEqualTo(String value) {
            addCriterion("RPT_TIME <=", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeLike(String value) {
            addCriterion("RPT_TIME like", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeNotLike(String value) {
            addCriterion("RPT_TIME not like", value, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeIn(List<String> values) {
            addCriterion("RPT_TIME in", values, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeNotIn(List<String> values) {
            addCriterion("RPT_TIME not in", values, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeBetween(String value1, String value2) {
            addCriterion("RPT_TIME between", value1, value2, "rptTime");
            return (Criteria) this;
        }

        public Criteria andRptTimeNotBetween(String value1, String value2) {
            addCriterion("RPT_TIME not between", value1, value2, "rptTime");
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