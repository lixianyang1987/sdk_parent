package com.hytx.model.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SyncTtfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SyncTtfExample() {
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

        public Criteria andOrdernoIsNull() {
            addCriterion("ORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("ORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(Long value) {
            addCriterion("ORDERNO =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(Long value) {
            addCriterion("ORDERNO <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(Long value) {
            addCriterion("ORDERNO >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERNO >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(Long value) {
            addCriterion("ORDERNO <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(Long value) {
            addCriterion("ORDERNO <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<Long> values) {
            addCriterion("ORDERNO in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<Long> values) {
            addCriterion("ORDERNO not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(Long value1, Long value2) {
            addCriterion("ORDERNO between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(Long value1, Long value2) {
            addCriterion("ORDERNO not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOpidIsNull() {
            addCriterion("OPID is null");
            return (Criteria) this;
        }

        public Criteria andOpidIsNotNull() {
            addCriterion("OPID is not null");
            return (Criteria) this;
        }

        public Criteria andOpidEqualTo(Short value) {
            addCriterion("OPID =", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotEqualTo(Short value) {
            addCriterion("OPID <>", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThan(Short value) {
            addCriterion("OPID >", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidGreaterThanOrEqualTo(Short value) {
            addCriterion("OPID >=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThan(Short value) {
            addCriterion("OPID <", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidLessThanOrEqualTo(Short value) {
            addCriterion("OPID <=", value, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidIn(List<Short> values) {
            addCriterion("OPID in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotIn(List<Short> values) {
            addCriterion("OPID not in", values, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidBetween(Short value1, Short value2) {
            addCriterion("OPID between", value1, value2, "opid");
            return (Criteria) this;
        }

        public Criteria andOpidNotBetween(Short value1, Short value2) {
            addCriterion("OPID not between", value1, value2, "opid");
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

        public Criteria andAppidEqualTo(Long value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Long value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Long value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Long value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Long value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Long value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Long> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Long> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Long value1, Long value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Long value1, Long value2) {
            addCriterion("APPID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("IMSI is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("IMSI is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(Long value) {
            addCriterion("IMSI =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(Long value) {
            addCriterion("IMSI <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(Long value) {
            addCriterion("IMSI >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(Long value) {
            addCriterion("IMSI >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(Long value) {
            addCriterion("IMSI <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(Long value) {
            addCriterion("IMSI <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<Long> values) {
            addCriterion("IMSI in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<Long> values) {
            addCriterion("IMSI not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(Long value1, Long value2) {
            addCriterion("IMSI between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(Long value1, Long value2) {
            addCriterion("IMSI not between", value1, value2, "imsi");
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

        public Criteria andFeeEqualTo(Short value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Short value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Short value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Short value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Short value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Short value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Short> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Short> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Short value1, Short value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Short value1, Short value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNull() {
            addCriterion("CHANNELID is null");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNotNull() {
            addCriterion("CHANNELID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelidEqualTo(String value) {
            addCriterion("CHANNELID =", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotEqualTo(String value) {
            addCriterion("CHANNELID <>", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThan(String value) {
            addCriterion("CHANNELID >", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNELID >=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThan(String value) {
            addCriterion("CHANNELID <", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThanOrEqualTo(String value) {
            addCriterion("CHANNELID <=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLike(String value) {
            addCriterion("CHANNELID like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotLike(String value) {
            addCriterion("CHANNELID not like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidIn(List<String> values) {
            addCriterion("CHANNELID in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotIn(List<String> values) {
            addCriterion("CHANNELID not in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidBetween(String value1, String value2) {
            addCriterion("CHANNELID between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotBetween(String value1, String value2) {
            addCriterion("CHANNELID not between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andExdataIsNull() {
            addCriterion("EXDATA is null");
            return (Criteria) this;
        }

        public Criteria andExdataIsNotNull() {
            addCriterion("EXDATA is not null");
            return (Criteria) this;
        }

        public Criteria andExdataEqualTo(String value) {
            addCriterion("EXDATA =", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotEqualTo(String value) {
            addCriterion("EXDATA <>", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataGreaterThan(String value) {
            addCriterion("EXDATA >", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataGreaterThanOrEqualTo(String value) {
            addCriterion("EXDATA >=", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLessThan(String value) {
            addCriterion("EXDATA <", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLessThanOrEqualTo(String value) {
            addCriterion("EXDATA <=", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataLike(String value) {
            addCriterion("EXDATA like", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotLike(String value) {
            addCriterion("EXDATA not like", value, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataIn(List<String> values) {
            addCriterion("EXDATA in", values, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotIn(List<String> values) {
            addCriterion("EXDATA not in", values, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataBetween(String value1, String value2) {
            addCriterion("EXDATA between", value1, value2, "exdata");
            return (Criteria) this;
        }

        public Criteria andExdataNotBetween(String value1, String value2) {
            addCriterion("EXDATA not between", value1, value2, "exdata");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("REGION is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("REGION is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("REGION =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("REGION <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("REGION >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("REGION >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("REGION <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("REGION <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("REGION like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("REGION not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("REGION in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("REGION not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("REGION between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("REGION not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNull() {
            addCriterion("RESULTCODE is null");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNotNull() {
            addCriterion("RESULTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andResultcodeEqualTo(String value) {
            addCriterion("RESULTCODE =", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotEqualTo(String value) {
            addCriterion("RESULTCODE <>", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThan(String value) {
            addCriterion("RESULTCODE >", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESULTCODE >=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThan(String value) {
            addCriterion("RESULTCODE <", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThanOrEqualTo(String value) {
            addCriterion("RESULTCODE <=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLike(String value) {
            addCriterion("RESULTCODE like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotLike(String value) {
            addCriterion("RESULTCODE not like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeIn(List<String> values) {
            addCriterion("RESULTCODE in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotIn(List<String> values) {
            addCriterion("RESULTCODE not in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeBetween(String value1, String value2) {
            addCriterion("RESULTCODE between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotBetween(String value1, String value2) {
            addCriterion("RESULTCODE not between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultdescIsNull() {
            addCriterion("RESULTDESC is null");
            return (Criteria) this;
        }

        public Criteria andResultdescIsNotNull() {
            addCriterion("RESULTDESC is not null");
            return (Criteria) this;
        }

        public Criteria andResultdescEqualTo(String value) {
            addCriterion("RESULTDESC =", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescNotEqualTo(String value) {
            addCriterion("RESULTDESC <>", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescGreaterThan(String value) {
            addCriterion("RESULTDESC >", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescGreaterThanOrEqualTo(String value) {
            addCriterion("RESULTDESC >=", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescLessThan(String value) {
            addCriterion("RESULTDESC <", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescLessThanOrEqualTo(String value) {
            addCriterion("RESULTDESC <=", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescLike(String value) {
            addCriterion("RESULTDESC like", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescNotLike(String value) {
            addCriterion("RESULTDESC not like", value, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescIn(List<String> values) {
            addCriterion("RESULTDESC in", values, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescNotIn(List<String> values) {
            addCriterion("RESULTDESC not in", values, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescBetween(String value1, String value2) {
            addCriterion("RESULTDESC between", value1, value2, "resultdesc");
            return (Criteria) this;
        }

        public Criteria andResultdescNotBetween(String value1, String value2) {
            addCriterion("RESULTDESC not between", value1, value2, "resultdesc");
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

        public Criteria andRpttimeIsNull() {
            addCriterion("RPTTIME is null");
            return (Criteria) this;
        }

        public Criteria andRpttimeIsNotNull() {
            addCriterion("RPTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRpttimeEqualTo(String value) {
            addCriterion("RPTTIME =", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotEqualTo(String value) {
            addCriterion("RPTTIME <>", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeGreaterThan(String value) {
            addCriterion("RPTTIME >", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeGreaterThanOrEqualTo(String value) {
            addCriterion("RPTTIME >=", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeLessThan(String value) {
            addCriterion("RPTTIME <", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeLessThanOrEqualTo(String value) {
            addCriterion("RPTTIME <=", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeLike(String value) {
            addCriterion("RPTTIME like", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotLike(String value) {
            addCriterion("RPTTIME not like", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeIn(List<String> values) {
            addCriterion("RPTTIME in", values, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotIn(List<String> values) {
            addCriterion("RPTTIME not in", values, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeBetween(String value1, String value2) {
            addCriterion("RPTTIME between", value1, value2, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotBetween(String value1, String value2) {
            addCriterion("RPTTIME not between", value1, value2, "rpttime");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIsNull() {
            addCriterion("SYNC_ALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIsNotNull() {
            addCriterion("SYNC_ALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdEqualTo(String value) {
            addCriterion("SYNC_ALL_ID =", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotEqualTo(String value) {
            addCriterion("SYNC_ALL_ID <>", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThan(String value) {
            addCriterion("SYNC_ALL_ID >", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYNC_ALL_ID >=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThan(String value) {
            addCriterion("SYNC_ALL_ID <", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLessThanOrEqualTo(String value) {
            addCriterion("SYNC_ALL_ID <=", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdLike(String value) {
            addCriterion("SYNC_ALL_ID like", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotLike(String value) {
            addCriterion("SYNC_ALL_ID not like", value, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdIn(List<String> values) {
            addCriterion("SYNC_ALL_ID in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotIn(List<String> values) {
            addCriterion("SYNC_ALL_ID not in", values, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdBetween(String value1, String value2) {
            addCriterion("SYNC_ALL_ID between", value1, value2, "syncAllId");
            return (Criteria) this;
        }

        public Criteria andSyncAllIdNotBetween(String value1, String value2) {
            addCriterion("SYNC_ALL_ID not between", value1, value2, "syncAllId");
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