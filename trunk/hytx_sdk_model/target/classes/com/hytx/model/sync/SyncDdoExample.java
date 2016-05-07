package com.hytx.model.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncDdoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncDdoExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andTelnoIsNull() {
            addCriterion("TELNO is null");
            return (Criteria) this;
        }

        public Criteria andTelnoIsNotNull() {
            addCriterion("TELNO is not null");
            return (Criteria) this;
        }

        public Criteria andTelnoEqualTo(String value) {
            addCriterion("TELNO =", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotEqualTo(String value) {
            addCriterion("TELNO <>", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoGreaterThan(String value) {
            addCriterion("TELNO >", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoGreaterThanOrEqualTo(String value) {
            addCriterion("TELNO >=", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoLessThan(String value) {
            addCriterion("TELNO <", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoLessThanOrEqualTo(String value) {
            addCriterion("TELNO <=", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoLike(String value) {
            addCriterion("TELNO like", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotLike(String value) {
            addCriterion("TELNO not like", value, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoIn(List<String> values) {
            addCriterion("TELNO in", values, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotIn(List<String> values) {
            addCriterion("TELNO not in", values, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoBetween(String value1, String value2) {
            addCriterion("TELNO between", value1, value2, "telno");
            return (Criteria) this;
        }

        public Criteria andTelnoNotBetween(String value1, String value2) {
            addCriterion("TELNO not between", value1, value2, "telno");
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

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNull() {
            addCriterion("ERRORCODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIsNotNull() {
            addCriterion("ERRORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcodeEqualTo(String value) {
            addCriterion("ERRORCODE =", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotEqualTo(String value) {
            addCriterion("ERRORCODE <>", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThan(String value) {
            addCriterion("ERRORCODE >", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERRORCODE >=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThan(String value) {
            addCriterion("ERRORCODE <", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLessThanOrEqualTo(String value) {
            addCriterion("ERRORCODE <=", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeLike(String value) {
            addCriterion("ERRORCODE like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotLike(String value) {
            addCriterion("ERRORCODE not like", value, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeIn(List<String> values) {
            addCriterion("ERRORCODE in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotIn(List<String> values) {
            addCriterion("ERRORCODE not in", values, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeBetween(String value1, String value2) {
            addCriterion("ERRORCODE between", value1, value2, "errorcode");
            return (Criteria) this;
        }

        public Criteria andErrorcodeNotBetween(String value1, String value2) {
            addCriterion("ERRORCODE not between", value1, value2, "errorcode");
            return (Criteria) this;
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

        public Criteria andMotimeIsNull() {
            addCriterion("MOTIME is null");
            return (Criteria) this;
        }

        public Criteria andMotimeIsNotNull() {
            addCriterion("MOTIME is not null");
            return (Criteria) this;
        }

        public Criteria andMotimeEqualTo(String value) {
            addCriterion("MOTIME =", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeNotEqualTo(String value) {
            addCriterion("MOTIME <>", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeGreaterThan(String value) {
            addCriterion("MOTIME >", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeGreaterThanOrEqualTo(String value) {
            addCriterion("MOTIME >=", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeLessThan(String value) {
            addCriterion("MOTIME <", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeLessThanOrEqualTo(String value) {
            addCriterion("MOTIME <=", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeLike(String value) {
            addCriterion("MOTIME like", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeNotLike(String value) {
            addCriterion("MOTIME not like", value, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeIn(List<String> values) {
            addCriterion("MOTIME in", values, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeNotIn(List<String> values) {
            addCriterion("MOTIME not in", values, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeBetween(String value1, String value2) {
            addCriterion("MOTIME between", value1, value2, "motime");
            return (Criteria) this;
        }

        public Criteria andMotimeNotBetween(String value1, String value2) {
            addCriterion("MOTIME not between", value1, value2, "motime");
            return (Criteria) this;
        }

        public Criteria andIsreduceIsNull() {
            addCriterion("ISREDUCE is null");
            return (Criteria) this;
        }

        public Criteria andIsreduceIsNotNull() {
            addCriterion("ISREDUCE is not null");
            return (Criteria) this;
        }

        public Criteria andIsreduceEqualTo(Integer value) {
            addCriterion("ISREDUCE =", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceNotEqualTo(Integer value) {
            addCriterion("ISREDUCE <>", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceGreaterThan(Integer value) {
            addCriterion("ISREDUCE >", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISREDUCE >=", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceLessThan(Integer value) {
            addCriterion("ISREDUCE <", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceLessThanOrEqualTo(Integer value) {
            addCriterion("ISREDUCE <=", value, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceIn(List<Integer> values) {
            addCriterion("ISREDUCE in", values, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceNotIn(List<Integer> values) {
            addCriterion("ISREDUCE not in", values, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceBetween(Integer value1, Integer value2) {
            addCriterion("ISREDUCE between", value1, value2, "isreduce");
            return (Criteria) this;
        }

        public Criteria andIsreduceNotBetween(Integer value1, Integer value2) {
            addCriterion("ISREDUCE not between", value1, value2, "isreduce");
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

        public Criteria andCoopidEqualTo(String value) {
            addCriterion("COOPID =", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotEqualTo(String value) {
            addCriterion("COOPID <>", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidGreaterThan(String value) {
            addCriterion("COOPID >", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidGreaterThanOrEqualTo(String value) {
            addCriterion("COOPID >=", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidLessThan(String value) {
            addCriterion("COOPID <", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidLessThanOrEqualTo(String value) {
            addCriterion("COOPID <=", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidLike(String value) {
            addCriterion("COOPID like", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotLike(String value) {
            addCriterion("COOPID not like", value, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidIn(List<String> values) {
            addCriterion("COOPID in", values, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotIn(List<String> values) {
            addCriterion("COOPID not in", values, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidBetween(String value1, String value2) {
            addCriterion("COOPID between", value1, value2, "coopid");
            return (Criteria) this;
        }

        public Criteria andCoopidNotBetween(String value1, String value2) {
            addCriterion("COOPID not between", value1, value2, "coopid");
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

        public Criteria andAppidIsNull() {
            addCriterion("APPID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("APPID like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("APPID not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("APPID not between", value1, value2, "appid");
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

        public Criteria andChannelAppIdEqualTo(String value) {
            addCriterion("CHANNEL_APP_ID =", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotEqualTo(String value) {
            addCriterion("CHANNEL_APP_ID <>", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThan(String value) {
            addCriterion("CHANNEL_APP_ID >", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_APP_ID >=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThan(String value) {
            addCriterion("CHANNEL_APP_ID <", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_APP_ID <=", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdLike(String value) {
            addCriterion("CHANNEL_APP_ID like", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotLike(String value) {
            addCriterion("CHANNEL_APP_ID not like", value, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdIn(List<String> values) {
            addCriterion("CHANNEL_APP_ID in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotIn(List<String> values) {
            addCriterion("CHANNEL_APP_ID not in", values, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_APP_ID between", value1, value2, "channelAppId");
            return (Criteria) this;
        }

        public Criteria andChannelAppIdNotBetween(String value1, String value2) {
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

        public Criteria andSyncStatusEqualTo(BigDecimal value) {
            addCriterion("SYNC_STATUS =", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotEqualTo(BigDecimal value) {
            addCriterion("SYNC_STATUS <>", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThan(BigDecimal value) {
            addCriterion("SYNC_STATUS >", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SYNC_STATUS >=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThan(BigDecimal value) {
            addCriterion("SYNC_STATUS <", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SYNC_STATUS <=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIn(List<BigDecimal> values) {
            addCriterion("SYNC_STATUS in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotIn(List<BigDecimal> values) {
            addCriterion("SYNC_STATUS not in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SYNC_STATUS between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andReduceStatusEqualTo(BigDecimal value) {
            addCriterion("REDUCE_STATUS =", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotEqualTo(BigDecimal value) {
            addCriterion("REDUCE_STATUS <>", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusGreaterThan(BigDecimal value) {
            addCriterion("REDUCE_STATUS >", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_STATUS >=", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusLessThan(BigDecimal value) {
            addCriterion("REDUCE_STATUS <", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REDUCE_STATUS <=", value, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusIn(List<BigDecimal> values) {
            addCriterion("REDUCE_STATUS in", values, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotIn(List<BigDecimal> values) {
            addCriterion("REDUCE_STATUS not in", values, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_STATUS between", value1, value2, "reduceStatus");
            return (Criteria) this;
        }

        public Criteria andReduceStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDUCE_STATUS not between", value1, value2, "reduceStatus");
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

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
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