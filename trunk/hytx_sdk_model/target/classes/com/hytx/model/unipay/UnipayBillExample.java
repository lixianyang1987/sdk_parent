package com.hytx.model.unipay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnipayBillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnipayBillExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
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

        public Criteria andUaIsNull() {
            addCriterion("UA is null");
            return (Criteria) this;
        }

        public Criteria andUaIsNotNull() {
            addCriterion("UA is not null");
            return (Criteria) this;
        }

        public Criteria andUaEqualTo(String value) {
            addCriterion("UA =", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotEqualTo(String value) {
            addCriterion("UA <>", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThan(String value) {
            addCriterion("UA >", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThanOrEqualTo(String value) {
            addCriterion("UA >=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThan(String value) {
            addCriterion("UA <", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThanOrEqualTo(String value) {
            addCriterion("UA <=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLike(String value) {
            addCriterion("UA like", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotLike(String value) {
            addCriterion("UA not like", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaIn(List<String> values) {
            addCriterion("UA in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotIn(List<String> values) {
            addCriterion("UA not in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaBetween(String value1, String value2) {
            addCriterion("UA between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotBetween(String value1, String value2) {
            addCriterion("UA not between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andVerSdkIsNull() {
            addCriterion("VER_SDK is null");
            return (Criteria) this;
        }

        public Criteria andVerSdkIsNotNull() {
            addCriterion("VER_SDK is not null");
            return (Criteria) this;
        }

        public Criteria andVerSdkEqualTo(String value) {
            addCriterion("VER_SDK =", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkNotEqualTo(String value) {
            addCriterion("VER_SDK <>", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkGreaterThan(String value) {
            addCriterion("VER_SDK >", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkGreaterThanOrEqualTo(String value) {
            addCriterion("VER_SDK >=", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkLessThan(String value) {
            addCriterion("VER_SDK <", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkLessThanOrEqualTo(String value) {
            addCriterion("VER_SDK <=", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkLike(String value) {
            addCriterion("VER_SDK like", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkNotLike(String value) {
            addCriterion("VER_SDK not like", value, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkIn(List<String> values) {
            addCriterion("VER_SDK in", values, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkNotIn(List<String> values) {
            addCriterion("VER_SDK not in", values, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkBetween(String value1, String value2) {
            addCriterion("VER_SDK between", value1, value2, "verSdk");
            return (Criteria) this;
        }

        public Criteria andVerSdkNotBetween(String value1, String value2) {
            addCriterion("VER_SDK not between", value1, value2, "verSdk");
            return (Criteria) this;
        }

        public Criteria andFeeValueIsNull() {
            addCriterion("FEE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFeeValueIsNotNull() {
            addCriterion("FEE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeValueEqualTo(String value) {
            addCriterion("FEE_VALUE =", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotEqualTo(String value) {
            addCriterion("FEE_VALUE <>", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThan(String value) {
            addCriterion("FEE_VALUE >", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_VALUE >=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThan(String value) {
            addCriterion("FEE_VALUE <", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThanOrEqualTo(String value) {
            addCriterion("FEE_VALUE <=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLike(String value) {
            addCriterion("FEE_VALUE like", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotLike(String value) {
            addCriterion("FEE_VALUE not like", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueIn(List<String> values) {
            addCriterion("FEE_VALUE in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotIn(List<String> values) {
            addCriterion("FEE_VALUE not in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueBetween(String value1, String value2) {
            addCriterion("FEE_VALUE between", value1, value2, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotBetween(String value1, String value2) {
            addCriterion("FEE_VALUE not between", value1, value2, "feeValue");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("ORDER_TIME like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("ORDER_TIME not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
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

        public Criteria andExtraInfoIsNull() {
            addCriterion("EXTRA_INFO is null");
            return (Criteria) this;
        }

        public Criteria andExtraInfoIsNotNull() {
            addCriterion("EXTRA_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andExtraInfoEqualTo(String value) {
            addCriterion("EXTRA_INFO =", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoNotEqualTo(String value) {
            addCriterion("EXTRA_INFO <>", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoGreaterThan(String value) {
            addCriterion("EXTRA_INFO >", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoGreaterThanOrEqualTo(String value) {
            addCriterion("EXTRA_INFO >=", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoLessThan(String value) {
            addCriterion("EXTRA_INFO <", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoLessThanOrEqualTo(String value) {
            addCriterion("EXTRA_INFO <=", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoLike(String value) {
            addCriterion("EXTRA_INFO like", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoNotLike(String value) {
            addCriterion("EXTRA_INFO not like", value, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoIn(List<String> values) {
            addCriterion("EXTRA_INFO in", values, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoNotIn(List<String> values) {
            addCriterion("EXTRA_INFO not in", values, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoBetween(String value1, String value2) {
            addCriterion("EXTRA_INFO between", value1, value2, "extraInfo");
            return (Criteria) this;
        }

        public Criteria andExtraInfoNotBetween(String value1, String value2) {
            addCriterion("EXTRA_INFO not between", value1, value2, "extraInfo");
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