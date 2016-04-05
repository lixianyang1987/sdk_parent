package com.hytx.model.xzf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XzfVcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XzfVcodeExample() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andVcodeIsNull() {
            addCriterion("VCODE is null");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNotNull() {
            addCriterion("VCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVcodeEqualTo(String value) {
            addCriterion("VCODE =", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotEqualTo(String value) {
            addCriterion("VCODE <>", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThan(String value) {
            addCriterion("VCODE >", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VCODE >=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThan(String value) {
            addCriterion("VCODE <", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThanOrEqualTo(String value) {
            addCriterion("VCODE <=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLike(String value) {
            addCriterion("VCODE like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotLike(String value) {
            addCriterion("VCODE not like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeIn(List<String> values) {
            addCriterion("VCODE in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotIn(List<String> values) {
            addCriterion("VCODE not in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeBetween(String value1, String value2) {
            addCriterion("VCODE between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotBetween(String value1, String value2) {
            addCriterion("VCODE not between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtIsNull() {
            addCriterion("EFFECTIVE_DT is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtIsNotNull() {
            addCriterion("EFFECTIVE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtEqualTo(Date value) {
            addCriterion("EFFECTIVE_DT =", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtNotEqualTo(Date value) {
            addCriterion("EFFECTIVE_DT <>", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtGreaterThan(Date value) {
            addCriterion("EFFECTIVE_DT >", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_DT >=", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtLessThan(Date value) {
            addCriterion("EFFECTIVE_DT <", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtLessThanOrEqualTo(Date value) {
            addCriterion("EFFECTIVE_DT <=", value, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtIn(List<Date> values) {
            addCriterion("EFFECTIVE_DT in", values, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtNotIn(List<Date> values) {
            addCriterion("EFFECTIVE_DT not in", values, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_DT between", value1, value2, "effectiveDt");
            return (Criteria) this;
        }

        public Criteria andEffectiveDtNotBetween(Date value1, Date value2) {
            addCriterion("EFFECTIVE_DT not between", value1, value2, "effectiveDt");
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