package com.hytx.model.xzf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XzfUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XzfUserExample() {
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

        public Criteria andImeiIsNull() {
            addCriterion("IMEI is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("IMEI is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("IMEI =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("IMEI <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("IMEI >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("IMEI >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("IMEI <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("IMEI <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("IMEI like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("IMEI not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("IMEI in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("IMEI not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("IMEI between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("IMEI not between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("IMSI is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("IMSI is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(String value) {
            addCriterion("IMSI =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(String value) {
            addCriterion("IMSI <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(String value) {
            addCriterion("IMSI >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(String value) {
            addCriterion("IMSI >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(String value) {
            addCriterion("IMSI <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(String value) {
            addCriterion("IMSI <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLike(String value) {
            addCriterion("IMSI like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotLike(String value) {
            addCriterion("IMSI not like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<String> values) {
            addCriterion("IMSI in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<String> values) {
            addCriterion("IMSI not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(String value1, String value2) {
            addCriterion("IMSI between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(String value1, String value2) {
            addCriterion("IMSI not between", value1, value2, "imsi");
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

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("ID_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("ID_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("ID_CARD =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("ID_CARD <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("ID_CARD >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("ID_CARD <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("ID_CARD like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("ID_CARD not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("ID_CARD in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("ID_CARD not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("ID_CARD between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("ID_CARD not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("INTEGRAL is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("INTEGRAL is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("INTEGRAL =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("INTEGRAL <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("INTEGRAL >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("INTEGRAL >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("INTEGRAL <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("INTEGRAL <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("INTEGRAL in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("INTEGRAL not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("INTEGRAL between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("INTEGRAL not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andHasCaredIsNull() {
            addCriterion("HAS_CARED is null");
            return (Criteria) this;
        }

        public Criteria andHasCaredIsNotNull() {
            addCriterion("HAS_CARED is not null");
            return (Criteria) this;
        }

        public Criteria andHasCaredEqualTo(Integer value) {
            addCriterion("HAS_CARED =", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredNotEqualTo(Integer value) {
            addCriterion("HAS_CARED <>", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredGreaterThan(Integer value) {
            addCriterion("HAS_CARED >", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredGreaterThanOrEqualTo(Integer value) {
            addCriterion("HAS_CARED >=", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredLessThan(Integer value) {
            addCriterion("HAS_CARED <", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredLessThanOrEqualTo(Integer value) {
            addCriterion("HAS_CARED <=", value, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredIn(List<Integer> values) {
            addCriterion("HAS_CARED in", values, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredNotIn(List<Integer> values) {
            addCriterion("HAS_CARED not in", values, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredBetween(Integer value1, Integer value2) {
            addCriterion("HAS_CARED between", value1, value2, "hasCared");
            return (Criteria) this;
        }

        public Criteria andHasCaredNotBetween(Integer value1, Integer value2) {
            addCriterion("HAS_CARED not between", value1, value2, "hasCared");
            return (Criteria) this;
        }

        public Criteria andDebtIsNull() {
            addCriterion("DEBT is null");
            return (Criteria) this;
        }

        public Criteria andDebtIsNotNull() {
            addCriterion("DEBT is not null");
            return (Criteria) this;
        }

        public Criteria andDebtEqualTo(Integer value) {
            addCriterion("DEBT =", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotEqualTo(Integer value) {
            addCriterion("DEBT <>", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtGreaterThan(Integer value) {
            addCriterion("DEBT >", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEBT >=", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtLessThan(Integer value) {
            addCriterion("DEBT <", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtLessThanOrEqualTo(Integer value) {
            addCriterion("DEBT <=", value, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtIn(List<Integer> values) {
            addCriterion("DEBT in", values, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotIn(List<Integer> values) {
            addCriterion("DEBT not in", values, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtBetween(Integer value1, Integer value2) {
            addCriterion("DEBT between", value1, value2, "debt");
            return (Criteria) this;
        }

        public Criteria andDebtNotBetween(Integer value1, Integer value2) {
            addCriterion("DEBT not between", value1, value2, "debt");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIsNull() {
            addCriterion("CREDIT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIsNotNull() {
            addCriterion("CREDIT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLevelEqualTo(Integer value) {
            addCriterion("CREDIT_LEVEL =", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotEqualTo(Integer value) {
            addCriterion("CREDIT_LEVEL <>", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelGreaterThan(Integer value) {
            addCriterion("CREDIT_LEVEL >", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREDIT_LEVEL >=", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelLessThan(Integer value) {
            addCriterion("CREDIT_LEVEL <", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelLessThanOrEqualTo(Integer value) {
            addCriterion("CREDIT_LEVEL <=", value, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelIn(List<Integer> values) {
            addCriterion("CREDIT_LEVEL in", values, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotIn(List<Integer> values) {
            addCriterion("CREDIT_LEVEL not in", values, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelBetween(Integer value1, Integer value2) {
            addCriterion("CREDIT_LEVEL between", value1, value2, "creditLevel");
            return (Criteria) this;
        }

        public Criteria andCreditLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("CREDIT_LEVEL not between", value1, value2, "creditLevel");
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

        public Criteria andChannelAppIdIsNull() {
            addCriterion("CHANNEL_APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIsNotNull() {
            addCriterion("CHANNEL_APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdEqualTo(Integer value) {
            addCriterion("CHANNEL_APP_ID =", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotEqualTo(Integer value) {
            addCriterion("CHANNEL_APP_ID <>", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThan(Integer value) {
            addCriterion("CHANNEL_APP_ID >", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHANNEL_APP_ID >=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThan(Integer value) {
            addCriterion("CHANNEL_APP_ID <", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("CHANNEL_APP_ID <=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIn(List<Integer> values) {
            addCriterion("CHANNEL_APP_ID in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotIn(List<Integer> values) {
            addCriterion("CHANNEL_APP_ID not in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdBetween(Integer value1, Integer value2) {
            addCriterion("CHANNEL_APP_ID between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CHANNEL_APP_ID not between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andDebtDtIsNull() {
            addCriterion("DEBT_DT is null");
            return (Criteria) this;
        }

        public Criteria andDebtDtIsNotNull() {
            addCriterion("DEBT_DT is not null");
            return (Criteria) this;
        }

        public Criteria andDebtDtEqualTo(Date value) {
            addCriterion("DEBT_DT =", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtNotEqualTo(Date value) {
            addCriterion("DEBT_DT <>", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtGreaterThan(Date value) {
            addCriterion("DEBT_DT >", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtGreaterThanOrEqualTo(Date value) {
            addCriterion("DEBT_DT >=", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtLessThan(Date value) {
            addCriterion("DEBT_DT <", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtLessThanOrEqualTo(Date value) {
            addCriterion("DEBT_DT <=", value, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtIn(List<Date> values) {
            addCriterion("DEBT_DT in", values, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtNotIn(List<Date> values) {
            addCriterion("DEBT_DT not in", values, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtBetween(Date value1, Date value2) {
            addCriterion("DEBT_DT between", value1, value2, "debtDt");
            return (Criteria) this;
        }

        public Criteria andDebtDtNotBetween(Date value1, Date value2) {
            addCriterion("DEBT_DT not between", value1, value2, "debtDt");
            return (Criteria) this;
        }

        public Criteria andPayDtIsNull() {
            addCriterion("PAY_DT is null");
            return (Criteria) this;
        }

        public Criteria andPayDtIsNotNull() {
            addCriterion("PAY_DT is not null");
            return (Criteria) this;
        }

        public Criteria andPayDtEqualTo(Date value) {
            addCriterion("PAY_DT =", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtNotEqualTo(Date value) {
            addCriterion("PAY_DT <>", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtGreaterThan(Date value) {
            addCriterion("PAY_DT >", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtGreaterThanOrEqualTo(Date value) {
            addCriterion("PAY_DT >=", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtLessThan(Date value) {
            addCriterion("PAY_DT <", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtLessThanOrEqualTo(Date value) {
            addCriterion("PAY_DT <=", value, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtIn(List<Date> values) {
            addCriterion("PAY_DT in", values, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtNotIn(List<Date> values) {
            addCriterion("PAY_DT not in", values, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtBetween(Date value1, Date value2) {
            addCriterion("PAY_DT between", value1, value2, "payDt");
            return (Criteria) this;
        }

        public Criteria andPayDtNotBetween(Date value1, Date value2) {
            addCriterion("PAY_DT not between", value1, value2, "payDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtIsNull() {
            addCriterion("SHOULD_PAY_DT is null");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtIsNotNull() {
            addCriterion("SHOULD_PAY_DT is not null");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtEqualTo(Date value) {
            addCriterion("SHOULD_PAY_DT =", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtNotEqualTo(Date value) {
            addCriterion("SHOULD_PAY_DT <>", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtGreaterThan(Date value) {
            addCriterion("SHOULD_PAY_DT >", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtGreaterThanOrEqualTo(Date value) {
            addCriterion("SHOULD_PAY_DT >=", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtLessThan(Date value) {
            addCriterion("SHOULD_PAY_DT <", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtLessThanOrEqualTo(Date value) {
            addCriterion("SHOULD_PAY_DT <=", value, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtIn(List<Date> values) {
            addCriterion("SHOULD_PAY_DT in", values, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtNotIn(List<Date> values) {
            addCriterion("SHOULD_PAY_DT not in", values, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtBetween(Date value1, Date value2) {
            addCriterion("SHOULD_PAY_DT between", value1, value2, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andShouldPayDtNotBetween(Date value1, Date value2) {
            addCriterion("SHOULD_PAY_DT not between", value1, value2, "shouldPayDt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtIsNull() {
            addCriterion("MAX_ALLOW_DEBT is null");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtIsNotNull() {
            addCriterion("MAX_ALLOW_DEBT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtEqualTo(Integer value) {
            addCriterion("MAX_ALLOW_DEBT =", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtNotEqualTo(Integer value) {
            addCriterion("MAX_ALLOW_DEBT <>", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtGreaterThan(Integer value) {
            addCriterion("MAX_ALLOW_DEBT >", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_ALLOW_DEBT >=", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtLessThan(Integer value) {
            addCriterion("MAX_ALLOW_DEBT <", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_ALLOW_DEBT <=", value, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtIn(List<Integer> values) {
            addCriterion("MAX_ALLOW_DEBT in", values, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtNotIn(List<Integer> values) {
            addCriterion("MAX_ALLOW_DEBT not in", values, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtBetween(Integer value1, Integer value2) {
            addCriterion("MAX_ALLOW_DEBT between", value1, value2, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andMaxAllowDebtNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_ALLOW_DEBT not between", value1, value2, "maxAllowDebt");
            return (Criteria) this;
        }

        public Criteria andExpireDtIsNull() {
            addCriterion("EXPIRE_DT is null");
            return (Criteria) this;
        }

        public Criteria andExpireDtIsNotNull() {
            addCriterion("EXPIRE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDtEqualTo(Date value) {
            addCriterion("EXPIRE_DT =", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtNotEqualTo(Date value) {
            addCriterion("EXPIRE_DT <>", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtGreaterThan(Date value) {
            addCriterion("EXPIRE_DT >", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_DT >=", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtLessThan(Date value) {
            addCriterion("EXPIRE_DT <", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_DT <=", value, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtIn(List<Date> values) {
            addCriterion("EXPIRE_DT in", values, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtNotIn(List<Date> values) {
            addCriterion("EXPIRE_DT not in", values, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_DT between", value1, value2, "expireDt");
            return (Criteria) this;
        }

        public Criteria andExpireDtNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_DT not between", value1, value2, "expireDt");
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