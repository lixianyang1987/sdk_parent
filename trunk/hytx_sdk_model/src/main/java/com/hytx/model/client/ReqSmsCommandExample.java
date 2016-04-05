package com.hytx.model.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReqSmsCommandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReqSmsCommandExample() {
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

        public Criteria andOperateIdIsNull() {
            addCriterion("OPERATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("OPERATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(Integer value) {
            addCriterion("OPERATE_ID =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(Integer value) {
            addCriterion("OPERATE_ID <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(Integer value) {
            addCriterion("OPERATE_ID >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATE_ID >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(Integer value) {
            addCriterion("OPERATE_ID <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATE_ID <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<Integer> values) {
            addCriterion("OPERATE_ID in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<Integer> values) {
            addCriterion("OPERATE_ID not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(Integer value1, Integer value2) {
            addCriterion("OPERATE_ID between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATE_ID not between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andMoNumIsNull() {
            addCriterion("MO_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMoNumIsNotNull() {
            addCriterion("MO_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMoNumEqualTo(String value) {
            addCriterion("MO_NUM =", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumNotEqualTo(String value) {
            addCriterion("MO_NUM <>", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumGreaterThan(String value) {
            addCriterion("MO_NUM >", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumGreaterThanOrEqualTo(String value) {
            addCriterion("MO_NUM >=", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumLessThan(String value) {
            addCriterion("MO_NUM <", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumLessThanOrEqualTo(String value) {
            addCriterion("MO_NUM <=", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumLike(String value) {
            addCriterion("MO_NUM like", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumNotLike(String value) {
            addCriterion("MO_NUM not like", value, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumIn(List<String> values) {
            addCriterion("MO_NUM in", values, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumNotIn(List<String> values) {
            addCriterion("MO_NUM not in", values, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumBetween(String value1, String value2) {
            addCriterion("MO_NUM between", value1, value2, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoNumNotBetween(String value1, String value2) {
            addCriterion("MO_NUM not between", value1, value2, "moNum");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNull() {
            addCriterion("MO_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMoContentIsNotNull() {
            addCriterion("MO_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMoContentEqualTo(String value) {
            addCriterion("MO_CONTENT =", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotEqualTo(String value) {
            addCriterion("MO_CONTENT <>", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThan(String value) {
            addCriterion("MO_CONTENT >", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentGreaterThanOrEqualTo(String value) {
            addCriterion("MO_CONTENT >=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThan(String value) {
            addCriterion("MO_CONTENT <", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLessThanOrEqualTo(String value) {
            addCriterion("MO_CONTENT <=", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentLike(String value) {
            addCriterion("MO_CONTENT like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotLike(String value) {
            addCriterion("MO_CONTENT not like", value, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentIn(List<String> values) {
            addCriterion("MO_CONTENT in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotIn(List<String> values) {
            addCriterion("MO_CONTENT not in", values, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentBetween(String value1, String value2) {
            addCriterion("MO_CONTENT between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andMoContentNotBetween(String value1, String value2) {
            addCriterion("MO_CONTENT not between", value1, value2, "moContent");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNull() {
            addCriterion("SEND_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("SEND_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            addCriterion("SEND_STATUS =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            addCriterion("SEND_STATUS <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            addCriterion("SEND_STATUS >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_STATUS >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(Integer value) {
            addCriterion("SEND_STATUS <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_STATUS <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            addCriterion("SEND_STATUS in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            addCriterion("SEND_STATUS not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            addCriterion("SEND_STATUS between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_STATUS not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendTimesIsNull() {
            addCriterion("SEND_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andSendTimesIsNotNull() {
            addCriterion("SEND_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimesEqualTo(Integer value) {
            addCriterion("SEND_TIMES =", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotEqualTo(Integer value) {
            addCriterion("SEND_TIMES <>", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesGreaterThan(Integer value) {
            addCriterion("SEND_TIMES >", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_TIMES >=", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesLessThan(Integer value) {
            addCriterion("SEND_TIMES <", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_TIMES <=", value, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesIn(List<Integer> values) {
            addCriterion("SEND_TIMES in", values, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotIn(List<Integer> values) {
            addCriterion("SEND_TIMES not in", values, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesBetween(Integer value1, Integer value2) {
            addCriterion("SEND_TIMES between", value1, value2, "sendTimes");
            return (Criteria) this;
        }

        public Criteria andSendTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_TIMES not between", value1, value2, "sendTimes");
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

        public Criteria andFeeValueIsNull() {
            addCriterion("FEE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFeeValueIsNotNull() {
            addCriterion("FEE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeValueEqualTo(Integer value) {
            addCriterion("FEE_VALUE =", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotEqualTo(Integer value) {
            addCriterion("FEE_VALUE <>", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThan(Integer value) {
            addCriterion("FEE_VALUE >", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_VALUE >=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThan(Integer value) {
            addCriterion("FEE_VALUE <", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_VALUE <=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueIn(List<Integer> values) {
            addCriterion("FEE_VALUE in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotIn(List<Integer> values) {
            addCriterion("FEE_VALUE not in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueBetween(Integer value1, Integer value2) {
            addCriterion("FEE_VALUE between", value1, value2, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_VALUE not between", value1, value2, "feeValue");
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

        public Criteria andPayPointIdIsNull() {
            addCriterion("PAY_POINT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayPointIdIsNotNull() {
            addCriterion("PAY_POINT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayPointIdEqualTo(Integer value) {
            addCriterion("PAY_POINT_ID =", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdNotEqualTo(Integer value) {
            addCriterion("PAY_POINT_ID <>", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdGreaterThan(Integer value) {
            addCriterion("PAY_POINT_ID >", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAY_POINT_ID >=", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdLessThan(Integer value) {
            addCriterion("PAY_POINT_ID <", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("PAY_POINT_ID <=", value, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdIn(List<Integer> values) {
            addCriterion("PAY_POINT_ID in", values, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdNotIn(List<Integer> values) {
            addCriterion("PAY_POINT_ID not in", values, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdBetween(Integer value1, Integer value2) {
            addCriterion("PAY_POINT_ID between", value1, value2, "payPointId");
            return (Criteria) this;
        }

        public Criteria andPayPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PAY_POINT_ID not between", value1, value2, "payPointId");
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

        public Criteria andTwoEnsureIsNull() {
            addCriterion("TWO_ENSURE is null");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureIsNotNull() {
            addCriterion("TWO_ENSURE is not null");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureEqualTo(String value) {
            addCriterion("TWO_ENSURE =", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureNotEqualTo(String value) {
            addCriterion("TWO_ENSURE <>", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureGreaterThan(String value) {
            addCriterion("TWO_ENSURE >", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_ENSURE >=", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureLessThan(String value) {
            addCriterion("TWO_ENSURE <", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureLessThanOrEqualTo(String value) {
            addCriterion("TWO_ENSURE <=", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureLike(String value) {
            addCriterion("TWO_ENSURE like", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureNotLike(String value) {
            addCriterion("TWO_ENSURE not like", value, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureIn(List<String> values) {
            addCriterion("TWO_ENSURE in", values, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureNotIn(List<String> values) {
            addCriterion("TWO_ENSURE not in", values, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureBetween(String value1, String value2) {
            addCriterion("TWO_ENSURE between", value1, value2, "twoEnsure");
            return (Criteria) this;
        }

        public Criteria andTwoEnsureNotBetween(String value1, String value2) {
            addCriterion("TWO_ENSURE not between", value1, value2, "twoEnsure");
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

        public Criteria andEnsureNumIsNull() {
            addCriterion("ENSURE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEnsureNumIsNotNull() {
            addCriterion("ENSURE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureNumEqualTo(BigDecimal value) {
            addCriterion("ENSURE_NUM =", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotEqualTo(BigDecimal value) {
            addCriterion("ENSURE_NUM <>", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumGreaterThan(BigDecimal value) {
            addCriterion("ENSURE_NUM >", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENSURE_NUM >=", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumLessThan(BigDecimal value) {
            addCriterion("ENSURE_NUM <", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENSURE_NUM <=", value, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumIn(List<BigDecimal> values) {
            addCriterion("ENSURE_NUM in", values, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotIn(List<BigDecimal> values) {
            addCriterion("ENSURE_NUM not in", values, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENSURE_NUM between", value1, value2, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andEnsureNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENSURE_NUM not between", value1, value2, "ensureNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNull() {
            addCriterion("SERIAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNotNull() {
            addCriterion("SERIAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumEqualTo(Integer value) {
            addCriterion("SERIAL_NUM =", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotEqualTo(Integer value) {
            addCriterion("SERIAL_NUM <>", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThan(Integer value) {
            addCriterion("SERIAL_NUM >", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUM >=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThan(Integer value) {
            addCriterion("SERIAL_NUM <", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThanOrEqualTo(Integer value) {
            addCriterion("SERIAL_NUM <=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumIn(List<Integer> values) {
            addCriterion("SERIAL_NUM in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotIn(List<Integer> values) {
            addCriterion("SERIAL_NUM not in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUM between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SERIAL_NUM not between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusIsNull() {
            addCriterion("ENSURE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusIsNotNull() {
            addCriterion("ENSURE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusEqualTo(Integer value) {
            addCriterion("ENSURE_STATUS =", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusNotEqualTo(Integer value) {
            addCriterion("ENSURE_STATUS <>", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusGreaterThan(Integer value) {
            addCriterion("ENSURE_STATUS >", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ENSURE_STATUS >=", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusLessThan(Integer value) {
            addCriterion("ENSURE_STATUS <", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ENSURE_STATUS <=", value, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusIn(List<Integer> values) {
            addCriterion("ENSURE_STATUS in", values, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusNotIn(List<Integer> values) {
            addCriterion("ENSURE_STATUS not in", values, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusBetween(Integer value1, Integer value2) {
            addCriterion("ENSURE_STATUS between", value1, value2, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andEnsureStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ENSURE_STATUS not between", value1, value2, "ensureStatus");
            return (Criteria) this;
        }

        public Criteria andHasLayoutIsNull() {
            addCriterion("HAS_LAYOUT is null");
            return (Criteria) this;
        }

        public Criteria andHasLayoutIsNotNull() {
            addCriterion("HAS_LAYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andHasLayoutEqualTo(Integer value) {
            addCriterion("HAS_LAYOUT =", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutNotEqualTo(Integer value) {
            addCriterion("HAS_LAYOUT <>", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutGreaterThan(Integer value) {
            addCriterion("HAS_LAYOUT >", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("HAS_LAYOUT >=", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutLessThan(Integer value) {
            addCriterion("HAS_LAYOUT <", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutLessThanOrEqualTo(Integer value) {
            addCriterion("HAS_LAYOUT <=", value, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutIn(List<Integer> values) {
            addCriterion("HAS_LAYOUT in", values, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutNotIn(List<Integer> values) {
            addCriterion("HAS_LAYOUT not in", values, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutBetween(Integer value1, Integer value2) {
            addCriterion("HAS_LAYOUT between", value1, value2, "hasLayout");
            return (Criteria) this;
        }

        public Criteria andHasLayoutNotBetween(Integer value1, Integer value2) {
            addCriterion("HAS_LAYOUT not between", value1, value2, "hasLayout");
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