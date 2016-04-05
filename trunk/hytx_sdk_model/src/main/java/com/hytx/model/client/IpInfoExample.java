package com.hytx.model.client;

import java.util.ArrayList;
import java.util.List;

public class IpInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IpInfoExample() {
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

        public Criteria andStartIpIsNull() {
            addCriterion("START_IP is null");
            return (Criteria) this;
        }

        public Criteria andStartIpIsNotNull() {
            addCriterion("START_IP is not null");
            return (Criteria) this;
        }

        public Criteria andStartIpEqualTo(String value) {
            addCriterion("START_IP =", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotEqualTo(String value) {
            addCriterion("START_IP <>", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpGreaterThan(String value) {
            addCriterion("START_IP >", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpGreaterThanOrEqualTo(String value) {
            addCriterion("START_IP >=", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLessThan(String value) {
            addCriterion("START_IP <", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLessThanOrEqualTo(String value) {
            addCriterion("START_IP <=", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpLike(String value) {
            addCriterion("START_IP like", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotLike(String value) {
            addCriterion("START_IP not like", value, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpIn(List<String> values) {
            addCriterion("START_IP in", values, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotIn(List<String> values) {
            addCriterion("START_IP not in", values, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpBetween(String value1, String value2) {
            addCriterion("START_IP between", value1, value2, "startIp");
            return (Criteria) this;
        }

        public Criteria andStartIpNotBetween(String value1, String value2) {
            addCriterion("START_IP not between", value1, value2, "startIp");
            return (Criteria) this;
        }

        public Criteria andEndIpIsNull() {
            addCriterion("END_IP is null");
            return (Criteria) this;
        }

        public Criteria andEndIpIsNotNull() {
            addCriterion("END_IP is not null");
            return (Criteria) this;
        }

        public Criteria andEndIpEqualTo(String value) {
            addCriterion("END_IP =", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotEqualTo(String value) {
            addCriterion("END_IP <>", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpGreaterThan(String value) {
            addCriterion("END_IP >", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpGreaterThanOrEqualTo(String value) {
            addCriterion("END_IP >=", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLessThan(String value) {
            addCriterion("END_IP <", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLessThanOrEqualTo(String value) {
            addCriterion("END_IP <=", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpLike(String value) {
            addCriterion("END_IP like", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotLike(String value) {
            addCriterion("END_IP not like", value, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpIn(List<String> values) {
            addCriterion("END_IP in", values, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotIn(List<String> values) {
            addCriterion("END_IP not in", values, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpBetween(String value1, String value2) {
            addCriterion("END_IP between", value1, value2, "endIp");
            return (Criteria) this;
        }

        public Criteria andEndIpNotBetween(String value1, String value2) {
            addCriterion("END_IP not between", value1, value2, "endIp");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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

        public Criteria andStartIpNumIsNull() {
            addCriterion("START_IP_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStartIpNumIsNotNull() {
            addCriterion("START_IP_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStartIpNumEqualTo(Long value) {
            addCriterion("START_IP_NUM =", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumNotEqualTo(Long value) {
            addCriterion("START_IP_NUM <>", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumGreaterThan(Long value) {
            addCriterion("START_IP_NUM >", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumGreaterThanOrEqualTo(Long value) {
            addCriterion("START_IP_NUM >=", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumLessThan(Long value) {
            addCriterion("START_IP_NUM <", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumLessThanOrEqualTo(Long value) {
            addCriterion("START_IP_NUM <=", value, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumIn(List<Long> values) {
            addCriterion("START_IP_NUM in", values, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumNotIn(List<Long> values) {
            addCriterion("START_IP_NUM not in", values, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumBetween(Long value1, Long value2) {
            addCriterion("START_IP_NUM between", value1, value2, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andStartIpNumNotBetween(Long value1, Long value2) {
            addCriterion("START_IP_NUM not between", value1, value2, "startIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumIsNull() {
            addCriterion("END_IP_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEndIpNumIsNotNull() {
            addCriterion("END_IP_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEndIpNumEqualTo(Long value) {
            addCriterion("END_IP_NUM =", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumNotEqualTo(Long value) {
            addCriterion("END_IP_NUM <>", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumGreaterThan(Long value) {
            addCriterion("END_IP_NUM >", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumGreaterThanOrEqualTo(Long value) {
            addCriterion("END_IP_NUM >=", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumLessThan(Long value) {
            addCriterion("END_IP_NUM <", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumLessThanOrEqualTo(Long value) {
            addCriterion("END_IP_NUM <=", value, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumIn(List<Long> values) {
            addCriterion("END_IP_NUM in", values, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumNotIn(List<Long> values) {
            addCriterion("END_IP_NUM not in", values, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumBetween(Long value1, Long value2) {
            addCriterion("END_IP_NUM between", value1, value2, "endIpNum");
            return (Criteria) this;
        }

        public Criteria andEndIpNumNotBetween(Long value1, Long value2) {
            addCriterion("END_IP_NUM not between", value1, value2, "endIpNum");
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