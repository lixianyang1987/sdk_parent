package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TdxltExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TdxltExample() {
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

        public Criteria andMsgtypeIsNull() {
            addCriterion("MSGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("MSGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("MSGTYPE =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("MSGTYPE <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("MSGTYPE >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MSGTYPE >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("MSGTYPE <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("MSGTYPE <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("MSGTYPE like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("MSGTYPE not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("MSGTYPE in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("MSGTYPE not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("MSGTYPE between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("MSGTYPE not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andUsernumberIsNull() {
            addCriterion("USERNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andUsernumberIsNotNull() {
            addCriterion("USERNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andUsernumberEqualTo(String value) {
            addCriterion("USERNUMBER =", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotEqualTo(String value) {
            addCriterion("USERNUMBER <>", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThan(String value) {
            addCriterion("USERNUMBER >", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThanOrEqualTo(String value) {
            addCriterion("USERNUMBER >=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThan(String value) {
            addCriterion("USERNUMBER <", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThanOrEqualTo(String value) {
            addCriterion("USERNUMBER <=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLike(String value) {
            addCriterion("USERNUMBER like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotLike(String value) {
            addCriterion("USERNUMBER not like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberIn(List<String> values) {
            addCriterion("USERNUMBER in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotIn(List<String> values) {
            addCriterion("USERNUMBER not in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberBetween(String value1, String value2) {
            addCriterion("USERNUMBER between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotBetween(String value1, String value2) {
            addCriterion("USERNUMBER not between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andFeecodeIsNull() {
            addCriterion("FEECODE is null");
            return (Criteria) this;
        }

        public Criteria andFeecodeIsNotNull() {
            addCriterion("FEECODE is not null");
            return (Criteria) this;
        }

        public Criteria andFeecodeEqualTo(Integer value) {
            addCriterion("FEECODE =", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotEqualTo(Integer value) {
            addCriterion("FEECODE <>", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeGreaterThan(Integer value) {
            addCriterion("FEECODE >", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEECODE >=", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeLessThan(Integer value) {
            addCriterion("FEECODE <", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeLessThanOrEqualTo(Integer value) {
            addCriterion("FEECODE <=", value, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeIn(List<Integer> values) {
            addCriterion("FEECODE in", values, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotIn(List<Integer> values) {
            addCriterion("FEECODE not in", values, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeBetween(Integer value1, Integer value2) {
            addCriterion("FEECODE between", value1, value2, "feecode");
            return (Criteria) this;
        }

        public Criteria andFeecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("FEECODE not between", value1, value2, "feecode");
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

        public Criteria andReporttimeIsNull() {
            addCriterion("REPORTTIME is null");
            return (Criteria) this;
        }

        public Criteria andReporttimeIsNotNull() {
            addCriterion("REPORTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andReporttimeEqualTo(String value) {
            addCriterion("REPORTTIME =", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotEqualTo(String value) {
            addCriterion("REPORTTIME <>", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThan(String value) {
            addCriterion("REPORTTIME >", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThanOrEqualTo(String value) {
            addCriterion("REPORTTIME >=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThan(String value) {
            addCriterion("REPORTTIME <", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThanOrEqualTo(String value) {
            addCriterion("REPORTTIME <=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLike(String value) {
            addCriterion("REPORTTIME like", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotLike(String value) {
            addCriterion("REPORTTIME not like", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeIn(List<String> values) {
            addCriterion("REPORTTIME in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotIn(List<String> values) {
            addCriterion("REPORTTIME not in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeBetween(String value1, String value2) {
            addCriterion("REPORTTIME between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotBetween(String value1, String value2) {
            addCriterion("REPORTTIME not between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNull() {
            addCriterion("GATEWAY is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNotNull() {
            addCriterion("GATEWAY is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayEqualTo(String value) {
            addCriterion("GATEWAY =", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotEqualTo(String value) {
            addCriterion("GATEWAY <>", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThan(String value) {
            addCriterion("GATEWAY >", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("GATEWAY >=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThan(String value) {
            addCriterion("GATEWAY <", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThanOrEqualTo(String value) {
            addCriterion("GATEWAY <=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLike(String value) {
            addCriterion("GATEWAY like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotLike(String value) {
            addCriterion("GATEWAY not like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayIn(List<String> values) {
            addCriterion("GATEWAY in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotIn(List<String> values) {
            addCriterion("GATEWAY not in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayBetween(String value1, String value2) {
            addCriterion("GATEWAY between", value1, value2, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotBetween(String value1, String value2) {
            addCriterion("GATEWAY not between", value1, value2, "gateway");
            return (Criteria) this;
        }

        public Criteria andMomsgIsNull() {
            addCriterion("MOMSG is null");
            return (Criteria) this;
        }

        public Criteria andMomsgIsNotNull() {
            addCriterion("MOMSG is not null");
            return (Criteria) this;
        }

        public Criteria andMomsgEqualTo(String value) {
            addCriterion("MOMSG =", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgNotEqualTo(String value) {
            addCriterion("MOMSG <>", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgGreaterThan(String value) {
            addCriterion("MOMSG >", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgGreaterThanOrEqualTo(String value) {
            addCriterion("MOMSG >=", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgLessThan(String value) {
            addCriterion("MOMSG <", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgLessThanOrEqualTo(String value) {
            addCriterion("MOMSG <=", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgLike(String value) {
            addCriterion("MOMSG like", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgNotLike(String value) {
            addCriterion("MOMSG not like", value, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgIn(List<String> values) {
            addCriterion("MOMSG in", values, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgNotIn(List<String> values) {
            addCriterion("MOMSG not in", values, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgBetween(String value1, String value2) {
            addCriterion("MOMSG between", value1, value2, "momsg");
            return (Criteria) this;
        }

        public Criteria andMomsgNotBetween(String value1, String value2) {
            addCriterion("MOMSG not between", value1, value2, "momsg");
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

        public Criteria andProductidIsNull() {
            addCriterion("PRODUCTID is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("PRODUCTID is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(String value) {
            addCriterion("PRODUCTID =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(String value) {
            addCriterion("PRODUCTID <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(String value) {
            addCriterion("PRODUCTID >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTID >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(String value) {
            addCriterion("PRODUCTID <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTID <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLike(String value) {
            addCriterion("PRODUCTID like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotLike(String value) {
            addCriterion("PRODUCTID not like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<String> values) {
            addCriterion("PRODUCTID in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<String> values) {
            addCriterion("PRODUCTID not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(String value1, String value2) {
            addCriterion("PRODUCTID between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(String value1, String value2) {
            addCriterion("PRODUCTID not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNull() {
            addCriterion("SERVICEID is null");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNotNull() {
            addCriterion("SERVICEID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceidEqualTo(String value) {
            addCriterion("SERVICEID =", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotEqualTo(String value) {
            addCriterion("SERVICEID <>", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThan(String value) {
            addCriterion("SERVICEID >", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICEID >=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThan(String value) {
            addCriterion("SERVICEID <", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThanOrEqualTo(String value) {
            addCriterion("SERVICEID <=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLike(String value) {
            addCriterion("SERVICEID like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotLike(String value) {
            addCriterion("SERVICEID not like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIn(List<String> values) {
            addCriterion("SERVICEID in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotIn(List<String> values) {
            addCriterion("SERVICEID not in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidBetween(String value1, String value2) {
            addCriterion("SERVICEID between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotBetween(String value1, String value2) {
            addCriterion("SERVICEID not between", value1, value2, "serviceid");
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