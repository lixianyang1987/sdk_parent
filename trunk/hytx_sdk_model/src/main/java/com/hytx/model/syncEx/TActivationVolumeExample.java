package com.hytx.model.syncEx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TActivationVolumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TActivationVolumeExample() {
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

        public Criteria andDaytimeIsNull() {
            addCriterion("DAYTIME is null");
            return (Criteria) this;
        }

        public Criteria andDaytimeIsNotNull() {
            addCriterion("DAYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andDaytimeEqualTo(Date value) {
            addCriterion("DAYTIME =", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotEqualTo(Date value) {
            addCriterion("DAYTIME <>", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeGreaterThan(Date value) {
            addCriterion("DAYTIME >", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DAYTIME >=", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeLessThan(Date value) {
            addCriterion("DAYTIME <", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeLessThanOrEqualTo(Date value) {
            addCriterion("DAYTIME <=", value, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeIn(List<Date> values) {
            addCriterion("DAYTIME in", values, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotIn(List<Date> values) {
            addCriterion("DAYTIME not in", values, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeBetween(Date value1, Date value2) {
            addCriterion("DAYTIME between", value1, value2, "daytime");
            return (Criteria) this;
        }

        public Criteria andDaytimeNotBetween(Date value1, Date value2) {
            addCriterion("DAYTIME not between", value1, value2, "daytime");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("CHANNEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("CHANNEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("CHANNEL_NAME =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("CHANNEL_NAME <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("CHANNEL_NAME >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_NAME >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("CHANNEL_NAME <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_NAME <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("CHANNEL_NAME like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("CHANNEL_NAME not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("CHANNEL_NAME in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("CHANNEL_NAME not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("CHANNEL_NAME between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_NAME not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("APP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("APP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("APP_NAME =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("APP_NAME <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("APP_NAME >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("APP_NAME >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("APP_NAME <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("APP_NAME <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("APP_NAME like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("APP_NAME not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("APP_NAME in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("APP_NAME not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("APP_NAME between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("APP_NAME not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIsNull() {
            addCriterion("COOPERATION_MODE is null");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIsNotNull() {
            addCriterion("COOPERATION_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationModeEqualTo(String value) {
            addCriterion("COOPERATION_MODE =", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotEqualTo(String value) {
            addCriterion("COOPERATION_MODE <>", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeGreaterThan(String value) {
            addCriterion("COOPERATION_MODE >", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeGreaterThanOrEqualTo(String value) {
            addCriterion("COOPERATION_MODE >=", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeLessThan(String value) {
            addCriterion("COOPERATION_MODE <", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeLessThanOrEqualTo(String value) {
            addCriterion("COOPERATION_MODE <=", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeLike(String value) {
            addCriterion("COOPERATION_MODE like", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotLike(String value) {
            addCriterion("COOPERATION_MODE not like", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIn(List<String> values) {
            addCriterion("COOPERATION_MODE in", values, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotIn(List<String> values) {
            addCriterion("COOPERATION_MODE not in", values, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeBetween(String value1, String value2) {
            addCriterion("COOPERATION_MODE between", value1, value2, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotBetween(String value1, String value2) {
            addCriterion("COOPERATION_MODE not between", value1, value2, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsIsNull() {
            addCriterion("THE_ACTIVATION_NUMS is null");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsIsNotNull() {
            addCriterion("THE_ACTIVATION_NUMS is not null");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsEqualTo(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS =", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsNotEqualTo(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS <>", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsGreaterThan(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS >", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS >=", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsLessThan(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS <", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsLessThanOrEqualTo(Integer value) {
            addCriterion("THE_ACTIVATION_NUMS <=", value, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsIn(List<Integer> values) {
            addCriterion("THE_ACTIVATION_NUMS in", values, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsNotIn(List<Integer> values) {
            addCriterion("THE_ACTIVATION_NUMS not in", values, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsBetween(Integer value1, Integer value2) {
            addCriterion("THE_ACTIVATION_NUMS between", value1, value2, "theActivationNums");
            return (Criteria) this;
        }

        public Criteria andTheActivationNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("THE_ACTIVATION_NUMS not between", value1, value2, "theActivationNums");
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

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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