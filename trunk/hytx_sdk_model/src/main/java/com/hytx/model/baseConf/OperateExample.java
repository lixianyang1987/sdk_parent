package com.hytx.model.baseConf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateExample() {
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

        public Criteria andOpNameIsNull() {
            addCriterion("OP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOpNameIsNotNull() {
            addCriterion("OP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOpNameEqualTo(String value) {
            addCriterion("OP_NAME =", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotEqualTo(String value) {
            addCriterion("OP_NAME <>", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThan(String value) {
            addCriterion("OP_NAME >", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThanOrEqualTo(String value) {
            addCriterion("OP_NAME >=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThan(String value) {
            addCriterion("OP_NAME <", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThanOrEqualTo(String value) {
            addCriterion("OP_NAME <=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLike(String value) {
            addCriterion("OP_NAME like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotLike(String value) {
            addCriterion("OP_NAME not like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameIn(List<String> values) {
            addCriterion("OP_NAME in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotIn(List<String> values) {
            addCriterion("OP_NAME not in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameBetween(String value1, String value2) {
            addCriterion("OP_NAME between", value1, value2, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotBetween(String value1, String value2) {
            addCriterion("OP_NAME not between", value1, value2, "opName");
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

        public Criteria andFeeCodeIsNull() {
            addCriterion("FEE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIsNotNull() {
            addCriterion("FEE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeCodeEqualTo(String value) {
            addCriterion("FEE_CODE =", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotEqualTo(String value) {
            addCriterion("FEE_CODE <>", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThan(String value) {
            addCriterion("FEE_CODE >", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_CODE >=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThan(String value) {
            addCriterion("FEE_CODE <", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLessThanOrEqualTo(String value) {
            addCriterion("FEE_CODE <=", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeLike(String value) {
            addCriterion("FEE_CODE like", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotLike(String value) {
            addCriterion("FEE_CODE not like", value, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeIn(List<String> values) {
            addCriterion("FEE_CODE in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotIn(List<String> values) {
            addCriterion("FEE_CODE not in", values, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeBetween(String value1, String value2) {
            addCriterion("FEE_CODE between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andFeeCodeNotBetween(String value1, String value2) {
            addCriterion("FEE_CODE not between", value1, value2, "feeCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeIsNull() {
            addCriterion("OP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOpCodeIsNotNull() {
            addCriterion("OP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOpCodeEqualTo(String value) {
            addCriterion("OP_CODE =", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeNotEqualTo(String value) {
            addCriterion("OP_CODE <>", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeGreaterThan(String value) {
            addCriterion("OP_CODE >", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OP_CODE >=", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeLessThan(String value) {
            addCriterion("OP_CODE <", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeLessThanOrEqualTo(String value) {
            addCriterion("OP_CODE <=", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeLike(String value) {
            addCriterion("OP_CODE like", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeNotLike(String value) {
            addCriterion("OP_CODE not like", value, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeIn(List<String> values) {
            addCriterion("OP_CODE in", values, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeNotIn(List<String> values) {
            addCriterion("OP_CODE not in", values, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeBetween(String value1, String value2) {
            addCriterion("OP_CODE between", value1, value2, "opCode");
            return (Criteria) this;
        }

        public Criteria andOpCodeNotBetween(String value1, String value2) {
            addCriterion("OP_CODE not between", value1, value2, "opCode");
            return (Criteria) this;
        }

        public Criteria andSuffixNumIsNull() {
            addCriterion("SUFFIX_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSuffixNumIsNotNull() {
            addCriterion("SUFFIX_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSuffixNumEqualTo(Integer value) {
            addCriterion("SUFFIX_NUM =", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumNotEqualTo(Integer value) {
            addCriterion("SUFFIX_NUM <>", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumGreaterThan(Integer value) {
            addCriterion("SUFFIX_NUM >", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUFFIX_NUM >=", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumLessThan(Integer value) {
            addCriterion("SUFFIX_NUM <", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumLessThanOrEqualTo(Integer value) {
            addCriterion("SUFFIX_NUM <=", value, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumIn(List<Integer> values) {
            addCriterion("SUFFIX_NUM in", values, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumNotIn(List<Integer> values) {
            addCriterion("SUFFIX_NUM not in", values, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumBetween(Integer value1, Integer value2) {
            addCriterion("SUFFIX_NUM between", value1, value2, "suffixNum");
            return (Criteria) this;
        }

        public Criteria andSuffixNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SUFFIX_NUM not between", value1, value2, "suffixNum");
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

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("OP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("OP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(Integer value) {
            addCriterion("OP_TYPE =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(Integer value) {
            addCriterion("OP_TYPE <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(Integer value) {
            addCriterion("OP_TYPE >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(Integer value) {
            addCriterion("OP_TYPE <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OP_TYPE <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<Integer> values) {
            addCriterion("OP_TYPE in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<Integer> values) {
            addCriterion("OP_TYPE not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OP_TYPE not between", value1, value2, "opType");
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

        public Criteria andEnsureTypeIsNull() {
            addCriterion("ENSURE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeIsNotNull() {
            addCriterion("ENSURE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeEqualTo(Integer value) {
            addCriterion("ENSURE_TYPE =", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeNotEqualTo(Integer value) {
            addCriterion("ENSURE_TYPE <>", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeGreaterThan(Integer value) {
            addCriterion("ENSURE_TYPE >", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENSURE_TYPE >=", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeLessThan(Integer value) {
            addCriterion("ENSURE_TYPE <", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ENSURE_TYPE <=", value, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeIn(List<Integer> values) {
            addCriterion("ENSURE_TYPE in", values, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeNotIn(List<Integer> values) {
            addCriterion("ENSURE_TYPE not in", values, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeBetween(Integer value1, Integer value2) {
            addCriterion("ENSURE_TYPE between", value1, value2, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ENSURE_TYPE not between", value1, value2, "ensureType");
            return (Criteria) this;
        }

        public Criteria andEnsureContentIsNull() {
            addCriterion("ENSURE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andEnsureContentIsNotNull() {
            addCriterion("ENSURE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureContentEqualTo(String value) {
            addCriterion("ENSURE_CONTENT =", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentNotEqualTo(String value) {
            addCriterion("ENSURE_CONTENT <>", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentGreaterThan(String value) {
            addCriterion("ENSURE_CONTENT >", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentGreaterThanOrEqualTo(String value) {
            addCriterion("ENSURE_CONTENT >=", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentLessThan(String value) {
            addCriterion("ENSURE_CONTENT <", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentLessThanOrEqualTo(String value) {
            addCriterion("ENSURE_CONTENT <=", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentLike(String value) {
            addCriterion("ENSURE_CONTENT like", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentNotLike(String value) {
            addCriterion("ENSURE_CONTENT not like", value, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentIn(List<String> values) {
            addCriterion("ENSURE_CONTENT in", values, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentNotIn(List<String> values) {
            addCriterion("ENSURE_CONTENT not in", values, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentBetween(String value1, String value2) {
            addCriterion("ENSURE_CONTENT between", value1, value2, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureContentNotBetween(String value1, String value2) {
            addCriterion("ENSURE_CONTENT not between", value1, value2, "ensureContent");
            return (Criteria) this;
        }

        public Criteria andEnsureNumIsNull() {
            addCriterion("ENSURE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEnsureNumIsNotNull() {
            addCriterion("ENSURE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureNumEqualTo(String value) {
            addCriterion("ENSURE_NUM =", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotEqualTo(String value) {
            addCriterion("ENSURE_NUM <>", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumGreaterThan(String value) {
            addCriterion("ENSURE_NUM >", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumGreaterThanOrEqualTo(String value) {
            addCriterion("ENSURE_NUM >=", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumLessThan(String value) {
            addCriterion("ENSURE_NUM <", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumLessThanOrEqualTo(String value) {
            addCriterion("ENSURE_NUM <=", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumLike(String value) {
            addCriterion("ENSURE_NUM like", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotLike(String value) {
            addCriterion("ENSURE_NUM not like", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumIn(List<String> values) {
            addCriterion("ENSURE_NUM in", values, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotIn(List<String> values) {
            addCriterion("ENSURE_NUM not in", values, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumBetween(String value1, String value2) {
            addCriterion("ENSURE_NUM between", value1, value2, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotBetween(String value1, String value2) {
            addCriterion("ENSURE_NUM not between", value1, value2, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andCpparamIsNull() {
            addCriterion("CPPARAM is null");
            return (Criteria) this;
        }

        public Criteria andCpparamIsNotNull() {
            addCriterion("CPPARAM is not null");
            return (Criteria) this;
        }

        public Criteria andCpparamEqualTo(String value) {
            addCriterion("CPPARAM =", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotEqualTo(String value) {
            addCriterion("CPPARAM <>", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamGreaterThan(String value) {
            addCriterion("CPPARAM >", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamGreaterThanOrEqualTo(String value) {
            addCriterion("CPPARAM >=", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLessThan(String value) {
            addCriterion("CPPARAM <", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLessThanOrEqualTo(String value) {
            addCriterion("CPPARAM <=", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamLike(String value) {
            addCriterion("CPPARAM like", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotLike(String value) {
            addCriterion("CPPARAM not like", value, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamIn(List<String> values) {
            addCriterion("CPPARAM in", values, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotIn(List<String> values) {
            addCriterion("CPPARAM not in", values, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamBetween(String value1, String value2) {
            addCriterion("CPPARAM between", value1, value2, "cpparam");
            return (Criteria) this;
        }

        public Criteria andCpparamNotBetween(String value1, String value2) {
            addCriterion("CPPARAM not between", value1, value2, "cpparam");
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