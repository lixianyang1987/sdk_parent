package com.hytx.model.baseConf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelAppExample() {
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

        public Criteria andChannelIdIsNull() {
            addCriterion("CHANNEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("CHANNEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("CHANNEL_ID =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("CHANNEL_ID <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("CHANNEL_ID >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHANNEL_ID >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("CHANNEL_ID <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("CHANNEL_ID <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("CHANNEL_ID in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("CHANNEL_ID not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("CHANNEL_ID between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CHANNEL_ID not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Integer value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Integer value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Integer value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Integer value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Integer> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Integer> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Integer value1, Integer value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
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

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
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

        public Criteria andPackageNameIsNull() {
            addCriterion("PACKAGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("PACKAGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("PACKAGE_NAME =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("PACKAGE_NAME <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("PACKAGE_NAME >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGE_NAME >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("PACKAGE_NAME <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("PACKAGE_NAME <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("PACKAGE_NAME like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("PACKAGE_NAME not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("PACKAGE_NAME in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("PACKAGE_NAME not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("PACKAGE_NAME between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("PACKAGE_NAME not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andFeeStatusIsNull() {
            addCriterion("FEE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFeeStatusIsNotNull() {
            addCriterion("FEE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFeeStatusEqualTo(Integer value) {
            addCriterion("FEE_STATUS =", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusNotEqualTo(Integer value) {
            addCriterion("FEE_STATUS <>", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusGreaterThan(Integer value) {
            addCriterion("FEE_STATUS >", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_STATUS >=", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusLessThan(Integer value) {
            addCriterion("FEE_STATUS <", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_STATUS <=", value, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusIn(List<Integer> values) {
            addCriterion("FEE_STATUS in", values, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusNotIn(List<Integer> values) {
            addCriterion("FEE_STATUS not in", values, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusBetween(Integer value1, Integer value2) {
            addCriterion("FEE_STATUS between", value1, value2, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andFeeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_STATUS not between", value1, value2, "feeStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusIsNull() {
            addCriterion("TEST_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTestStatusIsNotNull() {
            addCriterion("TEST_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTestStatusEqualTo(Integer value) {
            addCriterion("TEST_STATUS =", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotEqualTo(Integer value) {
            addCriterion("TEST_STATUS <>", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusGreaterThan(Integer value) {
            addCriterion("TEST_STATUS >", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("TEST_STATUS >=", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusLessThan(Integer value) {
            addCriterion("TEST_STATUS <", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusLessThanOrEqualTo(Integer value) {
            addCriterion("TEST_STATUS <=", value, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusIn(List<Integer> values) {
            addCriterion("TEST_STATUS in", values, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotIn(List<Integer> values) {
            addCriterion("TEST_STATUS not in", values, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusBetween(Integer value1, Integer value2) {
            addCriterion("TEST_STATUS between", value1, value2, "testStatus");
            return (Criteria) this;
        }

        public Criteria andTestStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("TEST_STATUS not between", value1, value2, "testStatus");
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

        public Criteria andSyncUrlIsNull() {
            addCriterion("SYNC_URL is null");
            return (Criteria) this;
        }

        public Criteria andSyncUrlIsNotNull() {
            addCriterion("SYNC_URL is not null");
            return (Criteria) this;
        }

        public Criteria andSyncUrlEqualTo(String value) {
            addCriterion("SYNC_URL =", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlNotEqualTo(String value) {
            addCriterion("SYNC_URL <>", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlGreaterThan(String value) {
            addCriterion("SYNC_URL >", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SYNC_URL >=", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlLessThan(String value) {
            addCriterion("SYNC_URL <", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlLessThanOrEqualTo(String value) {
            addCriterion("SYNC_URL <=", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlLike(String value) {
            addCriterion("SYNC_URL like", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlNotLike(String value) {
            addCriterion("SYNC_URL not like", value, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlIn(List<String> values) {
            addCriterion("SYNC_URL in", values, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlNotIn(List<String> values) {
            addCriterion("SYNC_URL not in", values, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlBetween(String value1, String value2) {
            addCriterion("SYNC_URL between", value1, value2, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andSyncUrlNotBetween(String value1, String value2) {
            addCriterion("SYNC_URL not between", value1, value2, "syncUrl");
            return (Criteria) this;
        }

        public Criteria andReducePercentIsNull() {
            addCriterion("REDUCE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andReducePercentIsNotNull() {
            addCriterion("REDUCE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andReducePercentEqualTo(Integer value) {
            addCriterion("REDUCE_PERCENT =", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentNotEqualTo(Integer value) {
            addCriterion("REDUCE_PERCENT <>", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentGreaterThan(Integer value) {
            addCriterion("REDUCE_PERCENT >", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("REDUCE_PERCENT >=", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentLessThan(Integer value) {
            addCriterion("REDUCE_PERCENT <", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentLessThanOrEqualTo(Integer value) {
            addCriterion("REDUCE_PERCENT <=", value, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentIn(List<Integer> values) {
            addCriterion("REDUCE_PERCENT in", values, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentNotIn(List<Integer> values) {
            addCriterion("REDUCE_PERCENT not in", values, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentBetween(Integer value1, Integer value2) {
            addCriterion("REDUCE_PERCENT between", value1, value2, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andReducePercentNotBetween(Integer value1, Integer value2) {
            addCriterion("REDUCE_PERCENT not between", value1, value2, "reducePercent");
            return (Criteria) this;
        }

        public Criteria andSignKeyIsNull() {
            addCriterion("SIGN_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSignKeyIsNotNull() {
            addCriterion("SIGN_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSignKeyEqualTo(String value) {
            addCriterion("SIGN_KEY =", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotEqualTo(String value) {
            addCriterion("SIGN_KEY <>", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyGreaterThan(String value) {
            addCriterion("SIGN_KEY >", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_KEY >=", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLessThan(String value) {
            addCriterion("SIGN_KEY <", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLessThanOrEqualTo(String value) {
            addCriterion("SIGN_KEY <=", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyLike(String value) {
            addCriterion("SIGN_KEY like", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotLike(String value) {
            addCriterion("SIGN_KEY not like", value, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyIn(List<String> values) {
            addCriterion("SIGN_KEY in", values, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotIn(List<String> values) {
            addCriterion("SIGN_KEY not in", values, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyBetween(String value1, String value2) {
            addCriterion("SIGN_KEY between", value1, value2, "signKey");
            return (Criteria) this;
        }

        public Criteria andSignKeyNotBetween(String value1, String value2) {
            addCriterion("SIGN_KEY not between", value1, value2, "signKey");
            return (Criteria) this;
        }

        public Criteria andDayLimitIsNull() {
            addCriterion("DAY_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andDayLimitIsNotNull() {
            addCriterion("DAY_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andDayLimitEqualTo(Integer value) {
            addCriterion("DAY_LIMIT =", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotEqualTo(Integer value) {
            addCriterion("DAY_LIMIT <>", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitGreaterThan(Integer value) {
            addCriterion("DAY_LIMIT >", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("DAY_LIMIT >=", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitLessThan(Integer value) {
            addCriterion("DAY_LIMIT <", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitLessThanOrEqualTo(Integer value) {
            addCriterion("DAY_LIMIT <=", value, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitIn(List<Integer> values) {
            addCriterion("DAY_LIMIT in", values, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotIn(List<Integer> values) {
            addCriterion("DAY_LIMIT not in", values, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitBetween(Integer value1, Integer value2) {
            addCriterion("DAY_LIMIT between", value1, value2, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andDayLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("DAY_LIMIT not between", value1, value2, "dayLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitIsNull() {
            addCriterion("MONTH_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andMonthLimitIsNotNull() {
            addCriterion("MONTH_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andMonthLimitEqualTo(Integer value) {
            addCriterion("MONTH_LIMIT =", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitNotEqualTo(Integer value) {
            addCriterion("MONTH_LIMIT <>", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitGreaterThan(Integer value) {
            addCriterion("MONTH_LIMIT >", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("MONTH_LIMIT >=", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitLessThan(Integer value) {
            addCriterion("MONTH_LIMIT <", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitLessThanOrEqualTo(Integer value) {
            addCriterion("MONTH_LIMIT <=", value, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitIn(List<Integer> values) {
            addCriterion("MONTH_LIMIT in", values, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitNotIn(List<Integer> values) {
            addCriterion("MONTH_LIMIT not in", values, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitBetween(Integer value1, Integer value2) {
            addCriterion("MONTH_LIMIT between", value1, value2, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andMonthLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("MONTH_LIMIT not between", value1, value2, "monthLimit");
            return (Criteria) this;
        }

        public Criteria andFeePercentIsNull() {
            addCriterion("FEE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andFeePercentIsNotNull() {
            addCriterion("FEE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andFeePercentEqualTo(Integer value) {
            addCriterion("FEE_PERCENT =", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentNotEqualTo(Integer value) {
            addCriterion("FEE_PERCENT <>", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentGreaterThan(Integer value) {
            addCriterion("FEE_PERCENT >", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_PERCENT >=", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentLessThan(Integer value) {
            addCriterion("FEE_PERCENT <", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_PERCENT <=", value, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentIn(List<Integer> values) {
            addCriterion("FEE_PERCENT in", values, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentNotIn(List<Integer> values) {
            addCriterion("FEE_PERCENT not in", values, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentBetween(Integer value1, Integer value2) {
            addCriterion("FEE_PERCENT between", value1, value2, "feePercent");
            return (Criteria) this;
        }

        public Criteria andFeePercentNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_PERCENT not between", value1, value2, "feePercent");
            return (Criteria) this;
        }

        public Criteria andCpaPriceIsNull() {
            addCriterion("CPA_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCpaPriceIsNotNull() {
            addCriterion("CPA_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCpaPriceEqualTo(Integer value) {
            addCriterion("CPA_PRICE =", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceNotEqualTo(Integer value) {
            addCriterion("CPA_PRICE <>", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceGreaterThan(Integer value) {
            addCriterion("CPA_PRICE >", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("CPA_PRICE >=", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceLessThan(Integer value) {
            addCriterion("CPA_PRICE <", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceLessThanOrEqualTo(Integer value) {
            addCriterion("CPA_PRICE <=", value, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceIn(List<Integer> values) {
            addCriterion("CPA_PRICE in", values, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceNotIn(List<Integer> values) {
            addCriterion("CPA_PRICE not in", values, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceBetween(Integer value1, Integer value2) {
            addCriterion("CPA_PRICE between", value1, value2, "cpaPrice");
            return (Criteria) this;
        }

        public Criteria andCpaPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("CPA_PRICE not between", value1, value2, "cpaPrice");
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