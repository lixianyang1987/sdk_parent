package com.hytx.model.syncEx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncYzfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncYzfExample() {
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

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(String value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(String value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(String value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(String value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(String value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(String value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLike(String value) {
            addCriterion("FEE like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotLike(String value) {
            addCriterion("FEE not like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<String> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<String> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(String value1, String value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(String value1, String value2) {
            addCriterion("FEE not between", value1, value2, "fee");
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

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("TIME like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("TIME not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "time");
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

        public Criteria andCoopidIsNull() {
            addCriterion("COOPID is null");
            return (Criteria) this;
        }

        public Criteria andCoopidIsNotNull() {
            addCriterion("COOPID is not null");
            return (Criteria) this;
        }

        public Criteria andCoopidEqualTo(Integer value) {
            addCriterion("COOPID =", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotEqualTo(Integer value) {
            addCriterion("COOPID <>", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidGreaterThan(Integer value) {
            addCriterion("COOPID >", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("COOPID >=", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidLessThan(Integer value) {
            addCriterion("COOPID <", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidLessThanOrEqualTo(Integer value) {
            addCriterion("COOPID <=", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidIn(List<Integer> values) {
            addCriterion("COOPID in", values, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotIn(List<Integer> values) {
            addCriterion("COOPID not in", values, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidBetween(Integer value1, Integer value2) {
            addCriterion("COOPID between", value1, value2, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotBetween(Integer value1, Integer value2) {
            addCriterion("COOPID not between", value1, value2, "coopid");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
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

        public Criteria andMsgIsNull() {
            addCriterion("MSG is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("MSG is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("MSG =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("MSG <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("MSG >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("MSG >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("MSG <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("MSG <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("MSG like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("MSG not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("MSG in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("MSG not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("MSG between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("MSG not between", value1, value2, "msg");
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