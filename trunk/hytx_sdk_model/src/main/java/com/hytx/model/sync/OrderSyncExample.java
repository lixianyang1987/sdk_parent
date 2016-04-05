package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.List;

public class OrderSyncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderSyncExample() {
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

        public Criteria andTransactionIdIsNull() {
            addCriterion("TRANSACTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("TRANSACTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("TRANSACTION_ID =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("TRANSACTION_ID <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("TRANSACTION_ID >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_ID >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("TRANSACTION_ID <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTION_ID <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("TRANSACTION_ID like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("TRANSACTION_ID not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("TRANSACTION_ID in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("TRANSACTION_ID not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("TRANSACTION_ID between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("TRANSACTION_ID not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultDescIsNull() {
            addCriterion("RESULT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andResultDescIsNotNull() {
            addCriterion("RESULT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andResultDescEqualTo(String value) {
            addCriterion("RESULT_DESC =", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescNotEqualTo(String value) {
            addCriterion("RESULT_DESC <>", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescGreaterThan(String value) {
            addCriterion("RESULT_DESC >", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT_DESC >=", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescLessThan(String value) {
            addCriterion("RESULT_DESC <", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescLessThanOrEqualTo(String value) {
            addCriterion("RESULT_DESC <=", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescLike(String value) {
            addCriterion("RESULT_DESC like", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescNotLike(String value) {
            addCriterion("RESULT_DESC not like", value, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescIn(List<String> values) {
            addCriterion("RESULT_DESC in", values, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescNotIn(List<String> values) {
            addCriterion("RESULT_DESC not in", values, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescBetween(String value1, String value2) {
            addCriterion("RESULT_DESC between", value1, value2, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andResultDescNotBetween(String value1, String value2) {
            addCriterion("RESULT_DESC not between", value1, value2, "resultDesc");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNull() {
            addCriterion("ACTION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNotNull() {
            addCriterion("ACTION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActionTimeEqualTo(String value) {
            addCriterion("ACTION_TIME =", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotEqualTo(String value) {
            addCriterion("ACTION_TIME <>", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThan(String value) {
            addCriterion("ACTION_TIME >", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_TIME >=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThan(String value) {
            addCriterion("ACTION_TIME <", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThanOrEqualTo(String value) {
            addCriterion("ACTION_TIME <=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLike(String value) {
            addCriterion("ACTION_TIME like", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotLike(String value) {
            addCriterion("ACTION_TIME not like", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeIn(List<String> values) {
            addCriterion("ACTION_TIME in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotIn(List<String> values) {
            addCriterion("ACTION_TIME not in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeBetween(String value1, String value2) {
            addCriterion("ACTION_TIME between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotBetween(String value1, String value2) {
            addCriterion("ACTION_TIME not between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMoIsNull() {
            addCriterion("MO is null");
            return (Criteria) this;
        }

        public Criteria andMoIsNotNull() {
            addCriterion("MO is not null");
            return (Criteria) this;
        }

        public Criteria andMoEqualTo(String value) {
            addCriterion("MO =", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotEqualTo(String value) {
            addCriterion("MO <>", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThan(String value) {
            addCriterion("MO >", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThanOrEqualTo(String value) {
            addCriterion("MO >=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThan(String value) {
            addCriterion("MO <", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThanOrEqualTo(String value) {
            addCriterion("MO <=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLike(String value) {
            addCriterion("MO like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotLike(String value) {
            addCriterion("MO not like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoIn(List<String> values) {
            addCriterion("MO in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotIn(List<String> values) {
            addCriterion("MO not in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoBetween(String value1, String value2) {
            addCriterion("MO between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotBetween(String value1, String value2) {
            addCriterion("MO not between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andDestIsNull() {
            addCriterion("DEST is null");
            return (Criteria) this;
        }

        public Criteria andDestIsNotNull() {
            addCriterion("DEST is not null");
            return (Criteria) this;
        }

        public Criteria andDestEqualTo(String value) {
            addCriterion("DEST =", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestNotEqualTo(String value) {
            addCriterion("DEST <>", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestGreaterThan(String value) {
            addCriterion("DEST >", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestGreaterThanOrEqualTo(String value) {
            addCriterion("DEST >=", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestLessThan(String value) {
            addCriterion("DEST <", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestLessThanOrEqualTo(String value) {
            addCriterion("DEST <=", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestLike(String value) {
            addCriterion("DEST like", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestNotLike(String value) {
            addCriterion("DEST not like", value, "dest");
            return (Criteria) this;
        }

        public Criteria andDestIn(List<String> values) {
            addCriterion("DEST in", values, "dest");
            return (Criteria) this;
        }

        public Criteria andDestNotIn(List<String> values) {
            addCriterion("DEST not in", values, "dest");
            return (Criteria) this;
        }

        public Criteria andDestBetween(String value1, String value2) {
            addCriterion("DEST between", value1, value2, "dest");
            return (Criteria) this;
        }

        public Criteria andDestNotBetween(String value1, String value2) {
            addCriterion("DEST not between", value1, value2, "dest");
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

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andPayCodeIsNull() {
            addCriterion("PAY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPayCodeIsNotNull() {
            addCriterion("PAY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPayCodeEqualTo(String value) {
            addCriterion("PAY_CODE =", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotEqualTo(String value) {
            addCriterion("PAY_CODE <>", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeGreaterThan(String value) {
            addCriterion("PAY_CODE >", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_CODE >=", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLessThan(String value) {
            addCriterion("PAY_CODE <", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLessThanOrEqualTo(String value) {
            addCriterion("PAY_CODE <=", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeLike(String value) {
            addCriterion("PAY_CODE like", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotLike(String value) {
            addCriterion("PAY_CODE not like", value, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeIn(List<String> values) {
            addCriterion("PAY_CODE in", values, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotIn(List<String> values) {
            addCriterion("PAY_CODE not in", values, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeBetween(String value1, String value2) {
            addCriterion("PAY_CODE between", value1, value2, "payCode");
            return (Criteria) this;
        }

        public Criteria andPayCodeNotBetween(String value1, String value2) {
            addCriterion("PAY_CODE not between", value1, value2, "payCode");
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

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
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

        public Criteria andCpParamIsNull() {
            addCriterion("CP_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andCpParamIsNotNull() {
            addCriterion("CP_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andCpParamEqualTo(String value) {
            addCriterion("CP_PARAM =", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamNotEqualTo(String value) {
            addCriterion("CP_PARAM <>", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamGreaterThan(String value) {
            addCriterion("CP_PARAM >", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamGreaterThanOrEqualTo(String value) {
            addCriterion("CP_PARAM >=", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamLessThan(String value) {
            addCriterion("CP_PARAM <", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamLessThanOrEqualTo(String value) {
            addCriterion("CP_PARAM <=", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamLike(String value) {
            addCriterion("CP_PARAM like", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamNotLike(String value) {
            addCriterion("CP_PARAM not like", value, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamIn(List<String> values) {
            addCriterion("CP_PARAM in", values, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamNotIn(List<String> values) {
            addCriterion("CP_PARAM not in", values, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamBetween(String value1, String value2) {
            addCriterion("CP_PARAM between", value1, value2, "cpParam");
            return (Criteria) this;
        }

        public Criteria andCpParamNotBetween(String value1, String value2) {
            addCriterion("CP_PARAM not between", value1, value2, "cpParam");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andHretIsNull() {
            addCriterion("HRET is null");
            return (Criteria) this;
        }

        public Criteria andHretIsNotNull() {
            addCriterion("HRET is not null");
            return (Criteria) this;
        }

        public Criteria andHretEqualTo(String value) {
            addCriterion("HRET =", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretNotEqualTo(String value) {
            addCriterion("HRET <>", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretGreaterThan(String value) {
            addCriterion("HRET >", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretGreaterThanOrEqualTo(String value) {
            addCriterion("HRET >=", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretLessThan(String value) {
            addCriterion("HRET <", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretLessThanOrEqualTo(String value) {
            addCriterion("HRET <=", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretLike(String value) {
            addCriterion("HRET like", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretNotLike(String value) {
            addCriterion("HRET not like", value, "hret");
            return (Criteria) this;
        }

        public Criteria andHretIn(List<String> values) {
            addCriterion("HRET in", values, "hret");
            return (Criteria) this;
        }

        public Criteria andHretNotIn(List<String> values) {
            addCriterion("HRET not in", values, "hret");
            return (Criteria) this;
        }

        public Criteria andHretBetween(String value1, String value2) {
            addCriterion("HRET between", value1, value2, "hret");
            return (Criteria) this;
        }

        public Criteria andHretNotBetween(String value1, String value2) {
            addCriterion("HRET not between", value1, value2, "hret");
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