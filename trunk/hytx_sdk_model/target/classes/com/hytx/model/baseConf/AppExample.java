package com.hytx.model.baseConf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppExample() {
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

        public Criteria andCpIdIsNull() {
            addCriterion("CP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNotNull() {
            addCriterion("CP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCpIdEqualTo(Integer value) {
            addCriterion("CP_ID =", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotEqualTo(Integer value) {
            addCriterion("CP_ID <>", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThan(Integer value) {
            addCriterion("CP_ID >", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CP_ID >=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThan(Integer value) {
            addCriterion("CP_ID <", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThanOrEqualTo(Integer value) {
            addCriterion("CP_ID <=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdIn(List<Integer> values) {
            addCriterion("CP_ID in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotIn(List<Integer> values) {
            addCriterion("CP_ID not in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdBetween(Integer value1, Integer value2) {
            addCriterion("CP_ID between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CP_ID not between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andAppDescribeIsNull() {
            addCriterion("APP_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andAppDescribeIsNotNull() {
            addCriterion("APP_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andAppDescribeEqualTo(String value) {
            addCriterion("APP_DESCRIBE =", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeNotEqualTo(String value) {
            addCriterion("APP_DESCRIBE <>", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeGreaterThan(String value) {
            addCriterion("APP_DESCRIBE >", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("APP_DESCRIBE >=", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeLessThan(String value) {
            addCriterion("APP_DESCRIBE <", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeLessThanOrEqualTo(String value) {
            addCriterion("APP_DESCRIBE <=", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeLike(String value) {
            addCriterion("APP_DESCRIBE like", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeNotLike(String value) {
            addCriterion("APP_DESCRIBE not like", value, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeIn(List<String> values) {
            addCriterion("APP_DESCRIBE in", values, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeNotIn(List<String> values) {
            addCriterion("APP_DESCRIBE not in", values, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeBetween(String value1, String value2) {
            addCriterion("APP_DESCRIBE between", value1, value2, "appDescribe");
            return (Criteria) this;
        }

        public Criteria andAppDescribeNotBetween(String value1, String value2) {
            addCriterion("APP_DESCRIBE not between", value1, value2, "appDescribe");
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

        public Criteria andAppSnIsNull() {
            addCriterion("APP_SN is null");
            return (Criteria) this;
        }

        public Criteria andAppSnIsNotNull() {
            addCriterion("APP_SN is not null");
            return (Criteria) this;
        }

        public Criteria andAppSnEqualTo(String value) {
            addCriterion("APP_SN =", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnNotEqualTo(String value) {
            addCriterion("APP_SN <>", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnGreaterThan(String value) {
            addCriterion("APP_SN >", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnGreaterThanOrEqualTo(String value) {
            addCriterion("APP_SN >=", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnLessThan(String value) {
            addCriterion("APP_SN <", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnLessThanOrEqualTo(String value) {
            addCriterion("APP_SN <=", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnLike(String value) {
            addCriterion("APP_SN like", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnNotLike(String value) {
            addCriterion("APP_SN not like", value, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnIn(List<String> values) {
            addCriterion("APP_SN in", values, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnNotIn(List<String> values) {
            addCriterion("APP_SN not in", values, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnBetween(String value1, String value2) {
            addCriterion("APP_SN between", value1, value2, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppSnNotBetween(String value1, String value2) {
            addCriterion("APP_SN not between", value1, value2, "appSn");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("APP_KEY is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("APP_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("APP_KEY =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("APP_KEY <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("APP_KEY >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("APP_KEY >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("APP_KEY <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("APP_KEY <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("APP_KEY like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("APP_KEY not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("APP_KEY in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("APP_KEY not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("APP_KEY between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("APP_KEY not between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNull() {
            addCriterion("SERVER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServerTypeIsNotNull() {
            addCriterion("SERVER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServerTypeEqualTo(Integer value) {
            addCriterion("SERVER_TYPE =", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotEqualTo(Integer value) {
            addCriterion("SERVER_TYPE <>", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThan(Integer value) {
            addCriterion("SERVER_TYPE >", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVER_TYPE >=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThan(Integer value) {
            addCriterion("SERVER_TYPE <", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SERVER_TYPE <=", value, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeIn(List<Integer> values) {
            addCriterion("SERVER_TYPE in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotIn(List<Integer> values) {
            addCriterion("SERVER_TYPE not in", values, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeBetween(Integer value1, Integer value2) {
            addCriterion("SERVER_TYPE between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andServerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVER_TYPE not between", value1, value2, "serverType");
            return (Criteria) this;
        }

        public Criteria andChannelSnIsNull() {
            addCriterion("CHANNEL_SN is null");
            return (Criteria) this;
        }

        public Criteria andChannelSnIsNotNull() {
            addCriterion("CHANNEL_SN is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSnEqualTo(String value) {
            addCriterion("CHANNEL_SN =", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnNotEqualTo(String value) {
            addCriterion("CHANNEL_SN <>", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnGreaterThan(String value) {
            addCriterion("CHANNEL_SN >", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SN >=", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnLessThan(String value) {
            addCriterion("CHANNEL_SN <", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SN <=", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnLike(String value) {
            addCriterion("CHANNEL_SN like", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnNotLike(String value) {
            addCriterion("CHANNEL_SN not like", value, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnIn(List<String> values) {
            addCriterion("CHANNEL_SN in", values, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnNotIn(List<String> values) {
            addCriterion("CHANNEL_SN not in", values, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnBetween(String value1, String value2) {
            addCriterion("CHANNEL_SN between", value1, value2, "channelSn");
            return (Criteria) this;
        }

        public Criteria andChannelSnNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_SN not between", value1, value2, "channelSn");
            return (Criteria) this;
        }

        public Criteria andControlFlagIsNull() {
            addCriterion("CONTROL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andControlFlagIsNotNull() {
            addCriterion("CONTROL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andControlFlagEqualTo(Integer value) {
            addCriterion("CONTROL_FLAG =", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotEqualTo(Integer value) {
            addCriterion("CONTROL_FLAG <>", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagGreaterThan(Integer value) {
            addCriterion("CONTROL_FLAG >", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("CONTROL_FLAG >=", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagLessThan(Integer value) {
            addCriterion("CONTROL_FLAG <", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagLessThanOrEqualTo(Integer value) {
            addCriterion("CONTROL_FLAG <=", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagIn(List<Integer> values) {
            addCriterion("CONTROL_FLAG in", values, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotIn(List<Integer> values) {
            addCriterion("CONTROL_FLAG not in", values, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagBetween(Integer value1, Integer value2) {
            addCriterion("CONTROL_FLAG between", value1, value2, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("CONTROL_FLAG not between", value1, value2, "controlFlag");
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

        public Criteria andWaitSecondsIsNull() {
            addCriterion("WAIT_SECONDS is null");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsIsNotNull() {
            addCriterion("WAIT_SECONDS is not null");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsEqualTo(Integer value) {
            addCriterion("WAIT_SECONDS =", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotEqualTo(Integer value) {
            addCriterion("WAIT_SECONDS <>", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThan(Integer value) {
            addCriterion("WAIT_SECONDS >", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThanOrEqualTo(Integer value) {
            addCriterion("WAIT_SECONDS >=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThan(Integer value) {
            addCriterion("WAIT_SECONDS <", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThanOrEqualTo(Integer value) {
            addCriterion("WAIT_SECONDS <=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsIn(List<Integer> values) {
            addCriterion("WAIT_SECONDS in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotIn(List<Integer> values) {
            addCriterion("WAIT_SECONDS not in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsBetween(Integer value1, Integer value2) {
            addCriterion("WAIT_SECONDS between", value1, value2, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotBetween(Integer value1, Integer value2) {
            addCriterion("WAIT_SECONDS not between", value1, value2, "waitSeconds");
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