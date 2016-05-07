package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpOrderSyncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpOrderSyncExample() {
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

        public Criteria andSendtypeIsNull() {
            addCriterion("SENDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("SENDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(Integer value) {
            addCriterion("SENDTYPE =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(Integer value) {
            addCriterion("SENDTYPE <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(Integer value) {
            addCriterion("SENDTYPE >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SENDTYPE >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(Integer value) {
            addCriterion("SENDTYPE <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(Integer value) {
            addCriterion("SENDTYPE <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<Integer> values) {
            addCriterion("SENDTYPE in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<Integer> values) {
            addCriterion("SENDTYPE not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(Integer value1, Integer value2) {
            addCriterion("SENDTYPE between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SENDTYPE not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andGageidIsNull() {
            addCriterion("GAGEID is null");
            return (Criteria) this;
        }

        public Criteria andGageidIsNotNull() {
            addCriterion("GAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andGageidEqualTo(String value) {
            addCriterion("GAGEID =", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidNotEqualTo(String value) {
            addCriterion("GAGEID <>", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidGreaterThan(String value) {
            addCriterion("GAGEID >", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidGreaterThanOrEqualTo(String value) {
            addCriterion("GAGEID >=", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidLessThan(String value) {
            addCriterion("GAGEID <", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidLessThanOrEqualTo(String value) {
            addCriterion("GAGEID <=", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidLike(String value) {
            addCriterion("GAGEID like", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidNotLike(String value) {
            addCriterion("GAGEID not like", value, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidIn(List<String> values) {
            addCriterion("GAGEID in", values, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidNotIn(List<String> values) {
            addCriterion("GAGEID not in", values, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidBetween(String value1, String value2) {
            addCriterion("GAGEID between", value1, value2, "gageid");
            return (Criteria) this;
        }

        public Criteria andGageidNotBetween(String value1, String value2) {
            addCriterion("GAGEID not between", value1, value2, "gageid");
            return (Criteria) this;
        }

        public Criteria andMoIsNull() {
            addCriterion("MO is null");
            return (Criteria) this;
        }

        public Criteria andMoIsNotNull() {
            addCriterion("MO is not null");
            return (Criteria) this;
        }

        public Criteria andMoEqualTo(String value) {
            addCriterion("MO =", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotEqualTo(String value) {
            addCriterion("MO <>", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThan(String value) {
            addCriterion("MO >", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThanOrEqualTo(String value) {
            addCriterion("MO >=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThan(String value) {
            addCriterion("MO <", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThanOrEqualTo(String value) {
            addCriterion("MO <=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLike(String value) {
            addCriterion("MO like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotLike(String value) {
            addCriterion("MO not like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoIn(List<String> values) {
            addCriterion("MO in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotIn(List<String> values) {
            addCriterion("MO not in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoBetween(String value1, String value2) {
            addCriterion("MO between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotBetween(String value1, String value2) {
            addCriterion("MO not between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("KEY is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("KEY is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("KEY =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("KEY <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("KEY >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("KEY >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("KEY <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("KEY <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("KEY like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("KEY not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("KEY in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("KEY not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("KEY between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("KEY not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andSpnumberIsNull() {
            addCriterion("SPNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSpnumberIsNotNull() {
            addCriterion("SPNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSpnumberEqualTo(String value) {
            addCriterion("SPNUMBER =", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberNotEqualTo(String value) {
            addCriterion("SPNUMBER <>", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberGreaterThan(String value) {
            addCriterion("SPNUMBER >", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberGreaterThanOrEqualTo(String value) {
            addCriterion("SPNUMBER >=", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberLessThan(String value) {
            addCriterion("SPNUMBER <", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberLessThanOrEqualTo(String value) {
            addCriterion("SPNUMBER <=", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberLike(String value) {
            addCriterion("SPNUMBER like", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberNotLike(String value) {
            addCriterion("SPNUMBER not like", value, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberIn(List<String> values) {
            addCriterion("SPNUMBER in", values, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberNotIn(List<String> values) {
            addCriterion("SPNUMBER not in", values, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberBetween(String value1, String value2) {
            addCriterion("SPNUMBER between", value1, value2, "spnumber");
            return (Criteria) this;
        }

        public Criteria andSpnumberNotBetween(String value1, String value2) {
            addCriterion("SPNUMBER not between", value1, value2, "spnumber");
            return (Criteria) this;
        }

        public Criteria andFeecodeIsNull() {
            addCriterion("FEECODE is null");
            return (Criteria) this;
        }

        public Criteria andFeecodeIsNotNull() {
            addCriterion("FEECODE is not null");
            return (Criteria) this;
        }

        public Criteria andFeecodeEqualTo(Integer value) {
            addCriterion("FEECODE =", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotEqualTo(Integer value) {
            addCriterion("FEECODE <>", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeGreaterThan(Integer value) {
            addCriterion("FEECODE >", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEECODE >=", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeLessThan(Integer value) {
            addCriterion("FEECODE <", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeLessThanOrEqualTo(Integer value) {
            addCriterion("FEECODE <=", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeIn(List<Integer> values) {
            addCriterion("FEECODE in", values, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotIn(List<Integer> values) {
            addCriterion("FEECODE not in", values, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeBetween(Integer value1, Integer value2) {
            addCriterion("FEECODE between", value1, value2, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("FEECODE not between", value1, value2, "feecode");
            return (Criteria) this;
        }

        public Criteria andSpcodeIsNull() {
            addCriterion("SPCODE is null");
            return (Criteria) this;
        }

        public Criteria andSpcodeIsNotNull() {
            addCriterion("SPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSpcodeEqualTo(Integer value) {
            addCriterion("SPCODE =", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeNotEqualTo(Integer value) {
            addCriterion("SPCODE <>", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeGreaterThan(Integer value) {
            addCriterion("SPCODE >", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPCODE >=", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeLessThan(Integer value) {
            addCriterion("SPCODE <", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeLessThanOrEqualTo(Integer value) {
            addCriterion("SPCODE <=", value, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeIn(List<Integer> values) {
            addCriterion("SPCODE in", values, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeNotIn(List<Integer> values) {
            addCriterion("SPCODE not in", values, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeBetween(Integer value1, Integer value2) {
            addCriterion("SPCODE between", value1, value2, "spcode");
            return (Criteria) this;
        }

        public Criteria andSpcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("SPCODE not between", value1, value2, "spcode");
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