package com.hytx.model.syncEx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TsyncexSkyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TsyncexSkyExample() {
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

        public Criteria andPhonenumIsNull() {
            addCriterion("PHONENUM is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("PHONENUM is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("PHONENUM =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("PHONENUM <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("PHONENUM >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("PHONENUM >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("PHONENUM <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("PHONENUM <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("PHONENUM like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("PHONENUM not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("PHONENUM in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("PHONENUM not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("PHONENUM between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("PHONENUM not between", value1, value2, "phonenum");
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

        public Criteria andExtIsNull() {
            addCriterion("EXT is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("EXT is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("EXT =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("EXT <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("EXT >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("EXT >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("EXT <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("EXT <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("EXT like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("EXT not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(List<String> values) {
            addCriterion("EXT in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(List<String> values) {
            addCriterion("EXT not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("EXT between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("EXT not between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNull() {
            addCriterion("SYNC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNotNull() {
            addCriterion("SYNC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusEqualTo(Integer value) {
            addCriterion("SYNC_STATUS =", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotEqualTo(Integer value) {
            addCriterion("SYNC_STATUS <>", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThan(Integer value) {
            addCriterion("SYNC_STATUS >", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYNC_STATUS >=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThan(Integer value) {
            addCriterion("SYNC_STATUS <", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SYNC_STATUS <=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIn(List<Integer> values) {
            addCriterion("SYNC_STATUS in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotIn(List<Integer> values) {
            addCriterion("SYNC_STATUS not in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_STATUS between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SYNC_STATUS not between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusIsNull() {
            addCriterion("REDUCE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andReduceStatusIsNotNull() {
            addCriterion("REDUCE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andReduceStatusEqualTo(Integer value) {
            addCriterion("REDUCE_STATUS =", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotEqualTo(Integer value) {
            addCriterion("REDUCE_STATUS <>", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusGreaterThan(Integer value) {
            addCriterion("REDUCE_STATUS >", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("REDUCE_STATUS >=", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusLessThan(Integer value) {
            addCriterion("REDUCE_STATUS <", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("REDUCE_STATUS <=", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusIn(List<Integer> values) {
            addCriterion("REDUCE_STATUS in", values, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotIn(List<Integer> values) {
            addCriterion("REDUCE_STATUS not in", values, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusBetween(Integer value1, Integer value2) {
            addCriterion("REDUCE_STATUS between", value1, value2, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("REDUCE_STATUS not between", value1, value2, "reduceStatus");
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

        public Criteria andChannelAppIdEqualTo(Long value) {
            addCriterion("CHANNEL_APP_ID =", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotEqualTo(Long value) {
            addCriterion("CHANNEL_APP_ID <>", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThan(Long value) {
            addCriterion("CHANNEL_APP_ID >", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_APP_ID >=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThan(Long value) {
            addCriterion("CHANNEL_APP_ID <", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThanOrEqualTo(Long value) {
            addCriterion("CHANNEL_APP_ID <=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIn(List<Long> values) {
            addCriterion("CHANNEL_APP_ID in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotIn(List<Long> values) {
            addCriterion("CHANNEL_APP_ID not in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_APP_ID between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotBetween(Long value1, Long value2) {
            addCriterion("CHANNEL_APP_ID not between", value1, value2, "channelAppId");
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

        public Criteria andCoopIdIsNull() {
            addCriterion("COOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCoopIdIsNotNull() {
            addCriterion("COOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCoopIdEqualTo(Integer value) {
            addCriterion("COOP_ID =", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdNotEqualTo(Integer value) {
            addCriterion("COOP_ID <>", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdGreaterThan(Integer value) {
            addCriterion("COOP_ID >", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COOP_ID >=", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdLessThan(Integer value) {
            addCriterion("COOP_ID <", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdLessThanOrEqualTo(Integer value) {
            addCriterion("COOP_ID <=", value, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdIn(List<Integer> values) {
            addCriterion("COOP_ID in", values, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdNotIn(List<Integer> values) {
            addCriterion("COOP_ID not in", values, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdBetween(Integer value1, Integer value2) {
            addCriterion("COOP_ID between", value1, value2, "coopId");
            return (Criteria) this;
        }

        public Criteria andCoopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COOP_ID not between", value1, value2, "coopId");
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