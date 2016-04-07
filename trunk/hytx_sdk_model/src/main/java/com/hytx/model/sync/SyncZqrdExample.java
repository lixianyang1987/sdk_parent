package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncZqrdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncZqrdExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
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

        public Criteria andReqContentIsNull() {
            addCriterion("REQ_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andReqContentIsNotNull() {
            addCriterion("REQ_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andReqContentEqualTo(String value) {
            addCriterion("REQ_CONTENT =", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentNotEqualTo(String value) {
            addCriterion("REQ_CONTENT <>", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentGreaterThan(String value) {
            addCriterion("REQ_CONTENT >", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_CONTENT >=", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentLessThan(String value) {
            addCriterion("REQ_CONTENT <", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentLessThanOrEqualTo(String value) {
            addCriterion("REQ_CONTENT <=", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentLike(String value) {
            addCriterion("REQ_CONTENT like", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentNotLike(String value) {
            addCriterion("REQ_CONTENT not like", value, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentIn(List<String> values) {
            addCriterion("REQ_CONTENT in", values, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentNotIn(List<String> values) {
            addCriterion("REQ_CONTENT not in", values, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentBetween(String value1, String value2) {
            addCriterion("REQ_CONTENT between", value1, value2, "reqContent");
            return (Criteria) this;
        }

        public Criteria andReqContentNotBetween(String value1, String value2) {
            addCriterion("REQ_CONTENT not between", value1, value2, "reqContent");
            return (Criteria) this;
        }

        public Criteria andChannelappidIsNull() {
            addCriterion("CHANNELAPPID is null");
            return (Criteria) this;
        }

        public Criteria andChannelappidIsNotNull() {
            addCriterion("CHANNELAPPID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelappidEqualTo(Integer value) {
            addCriterion("CHANNELAPPID =", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidNotEqualTo(Integer value) {
            addCriterion("CHANNELAPPID <>", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidGreaterThan(Integer value) {
            addCriterion("CHANNELAPPID >", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHANNELAPPID >=", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidLessThan(Integer value) {
            addCriterion("CHANNELAPPID <", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidLessThanOrEqualTo(Integer value) {
            addCriterion("CHANNELAPPID <=", value, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidIn(List<Integer> values) {
            addCriterion("CHANNELAPPID in", values, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidNotIn(List<Integer> values) {
            addCriterion("CHANNELAPPID not in", values, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidBetween(Integer value1, Integer value2) {
            addCriterion("CHANNELAPPID between", value1, value2, "channelappid");
            return (Criteria) this;
        }

        public Criteria andChannelappidNotBetween(Integer value1, Integer value2) {
            addCriterion("CHANNELAPPID not between", value1, value2, "channelappid");
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