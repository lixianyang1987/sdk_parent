package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncSkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncSkExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("ORDERID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("ORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("ORDERID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("ORDERID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("ORDERID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("ORDERID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("ORDERID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("ORDERID like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("ORDERID not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("ORDERID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("ORDERID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("ORDERID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("ORDERID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andTradeidIsNull() {
            addCriterion("TRADEID is null");
            return (Criteria) this;
        }

        public Criteria andTradeidIsNotNull() {
            addCriterion("TRADEID is not null");
            return (Criteria) this;
        }

        public Criteria andTradeidEqualTo(String value) {
            addCriterion("TRADEID =", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidNotEqualTo(String value) {
            addCriterion("TRADEID <>", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidGreaterThan(String value) {
            addCriterion("TRADEID >", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidGreaterThanOrEqualTo(String value) {
            addCriterion("TRADEID >=", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidLessThan(String value) {
            addCriterion("TRADEID <", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidLessThanOrEqualTo(String value) {
            addCriterion("TRADEID <=", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidLike(String value) {
            addCriterion("TRADEID like", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidNotLike(String value) {
            addCriterion("TRADEID not like", value, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidIn(List<String> values) {
            addCriterion("TRADEID in", values, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidNotIn(List<String> values) {
            addCriterion("TRADEID not in", values, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidBetween(String value1, String value2) {
            addCriterion("TRADEID between", value1, value2, "tradeid");
            return (Criteria) this;
        }

        public Criteria andTradeidNotBetween(String value1, String value2) {
            addCriterion("TRADEID not between", value1, value2, "tradeid");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("PRICE like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("PRICE not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnIsNull() {
            addCriterion("FEEMSISDN is null");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnIsNotNull() {
            addCriterion("FEEMSISDN is not null");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnEqualTo(String value) {
            addCriterion("FEEMSISDN =", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnNotEqualTo(String value) {
            addCriterion("FEEMSISDN <>", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnGreaterThan(String value) {
            addCriterion("FEEMSISDN >", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnGreaterThanOrEqualTo(String value) {
            addCriterion("FEEMSISDN >=", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnLessThan(String value) {
            addCriterion("FEEMSISDN <", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnLessThanOrEqualTo(String value) {
            addCriterion("FEEMSISDN <=", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnLike(String value) {
            addCriterion("FEEMSISDN like", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnNotLike(String value) {
            addCriterion("FEEMSISDN not like", value, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnIn(List<String> values) {
            addCriterion("FEEMSISDN in", values, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnNotIn(List<String> values) {
            addCriterion("FEEMSISDN not in", values, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnBetween(String value1, String value2) {
            addCriterion("FEEMSISDN between", value1, value2, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andFeemsisdnNotBetween(String value1, String value2) {
            addCriterion("FEEMSISDN not between", value1, value2, "feemsisdn");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("APPID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("APPID like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("APPID not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("APPID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andPaycodeIsNull() {
            addCriterion("PAYCODE is null");
            return (Criteria) this;
        }

        public Criteria andPaycodeIsNotNull() {
            addCriterion("PAYCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPaycodeEqualTo(String value) {
            addCriterion("PAYCODE =", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeNotEqualTo(String value) {
            addCriterion("PAYCODE <>", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeGreaterThan(String value) {
            addCriterion("PAYCODE >", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYCODE >=", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeLessThan(String value) {
            addCriterion("PAYCODE <", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeLessThanOrEqualTo(String value) {
            addCriterion("PAYCODE <=", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeLike(String value) {
            addCriterion("PAYCODE like", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeNotLike(String value) {
            addCriterion("PAYCODE not like", value, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeIn(List<String> values) {
            addCriterion("PAYCODE in", values, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeNotIn(List<String> values) {
            addCriterion("PAYCODE not in", values, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeBetween(String value1, String value2) {
            addCriterion("PAYCODE between", value1, value2, "paycode");
            return (Criteria) this;
        }

        public Criteria andPaycodeNotBetween(String value1, String value2) {
            addCriterion("PAYCODE not between", value1, value2, "paycode");
            return (Criteria) this;
        }

        public Criteria andExdataIsNull() {
            addCriterion("EXDATA is null");
            return (Criteria) this;
        }

        public Criteria andExdataIsNotNull() {
            addCriterion("EXDATA is not null");
            return (Criteria) this;
        }

        public Criteria andExdataEqualTo(String value) {
            addCriterion("EXDATA =", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotEqualTo(String value) {
            addCriterion("EXDATA <>", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataGreaterThan(String value) {
            addCriterion("EXDATA >", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataGreaterThanOrEqualTo(String value) {
            addCriterion("EXDATA >=", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLessThan(String value) {
            addCriterion("EXDATA <", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLessThanOrEqualTo(String value) {
            addCriterion("EXDATA <=", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLike(String value) {
            addCriterion("EXDATA like", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotLike(String value) {
            addCriterion("EXDATA not like", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataIn(List<String> values) {
            addCriterion("EXDATA in", values, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotIn(List<String> values) {
            addCriterion("EXDATA not in", values, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataBetween(String value1, String value2) {
            addCriterion("EXDATA between", value1, value2, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotBetween(String value1, String value2) {
            addCriterion("EXDATA not between", value1, value2, "exdata");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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