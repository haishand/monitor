package po;

import java.util.ArrayList;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("deviceId =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("deviceId <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("deviceId >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceId >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("deviceId <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("deviceId <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("deviceId in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("deviceId not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("deviceId between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceId not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("nodeId is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("nodeId is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("nodeId =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("nodeId <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("nodeId >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodeId >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("nodeId <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("nodeId <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("nodeId in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("nodeId not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("nodeId between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("nodeId not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andMultiFlagIsNull() {
            addCriterion("multiFlag is null");
            return (Criteria) this;
        }

        public Criteria andMultiFlagIsNotNull() {
            addCriterion("multiFlag is not null");
            return (Criteria) this;
        }

        public Criteria andMultiFlagEqualTo(Boolean value) {
            addCriterion("multiFlag =", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagNotEqualTo(Boolean value) {
            addCriterion("multiFlag <>", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagGreaterThan(Boolean value) {
            addCriterion("multiFlag >", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("multiFlag >=", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagLessThan(Boolean value) {
            addCriterion("multiFlag <", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("multiFlag <=", value, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagIn(List<Boolean> values) {
            addCriterion("multiFlag in", values, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagNotIn(List<Boolean> values) {
            addCriterion("multiFlag not in", values, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("multiFlag between", value1, value2, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andMultiFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("multiFlag not between", value1, value2, "multiFlag");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("deviceName is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("deviceName is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("deviceName =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("deviceName <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("deviceName >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("deviceName >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("deviceName <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("deviceName <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("deviceName like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("deviceName not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("deviceName in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("deviceName not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("deviceName between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("deviceName not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("deviceType is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("deviceType is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Integer value) {
            addCriterion("deviceType =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Integer value) {
            addCriterion("deviceType <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Integer value) {
            addCriterion("deviceType >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceType >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Integer value) {
            addCriterion("deviceType <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("deviceType <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Integer> values) {
            addCriterion("deviceType in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Integer> values) {
            addCriterion("deviceType not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("deviceType between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceType not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andParam1NameIsNull() {
            addCriterion("param1Name is null");
            return (Criteria) this;
        }

        public Criteria andParam1NameIsNotNull() {
            addCriterion("param1Name is not null");
            return (Criteria) this;
        }

        public Criteria andParam1NameEqualTo(String value) {
            addCriterion("param1Name =", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameNotEqualTo(String value) {
            addCriterion("param1Name <>", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameGreaterThan(String value) {
            addCriterion("param1Name >", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameGreaterThanOrEqualTo(String value) {
            addCriterion("param1Name >=", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameLessThan(String value) {
            addCriterion("param1Name <", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameLessThanOrEqualTo(String value) {
            addCriterion("param1Name <=", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameLike(String value) {
            addCriterion("param1Name like", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameNotLike(String value) {
            addCriterion("param1Name not like", value, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameIn(List<String> values) {
            addCriterion("param1Name in", values, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameNotIn(List<String> values) {
            addCriterion("param1Name not in", values, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameBetween(String value1, String value2) {
            addCriterion("param1Name between", value1, value2, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam1NameNotBetween(String value1, String value2) {
            addCriterion("param1Name not between", value1, value2, "param1Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameIsNull() {
            addCriterion("param2Name is null");
            return (Criteria) this;
        }

        public Criteria andParam2NameIsNotNull() {
            addCriterion("param2Name is not null");
            return (Criteria) this;
        }

        public Criteria andParam2NameEqualTo(String value) {
            addCriterion("param2Name =", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameNotEqualTo(String value) {
            addCriterion("param2Name <>", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameGreaterThan(String value) {
            addCriterion("param2Name >", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameGreaterThanOrEqualTo(String value) {
            addCriterion("param2Name >=", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameLessThan(String value) {
            addCriterion("param2Name <", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameLessThanOrEqualTo(String value) {
            addCriterion("param2Name <=", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameLike(String value) {
            addCriterion("param2Name like", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameNotLike(String value) {
            addCriterion("param2Name not like", value, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameIn(List<String> values) {
            addCriterion("param2Name in", values, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameNotIn(List<String> values) {
            addCriterion("param2Name not in", values, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameBetween(String value1, String value2) {
            addCriterion("param2Name between", value1, value2, "param2Name");
            return (Criteria) this;
        }

        public Criteria andParam2NameNotBetween(String value1, String value2) {
            addCriterion("param2Name not between", value1, value2, "param2Name");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalIsNull() {
            addCriterion("saveInterval is null");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalIsNotNull() {
            addCriterion("saveInterval is not null");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalEqualTo(Integer value) {
            addCriterion("saveInterval =", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalNotEqualTo(Integer value) {
            addCriterion("saveInterval <>", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalGreaterThan(Integer value) {
            addCriterion("saveInterval >", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("saveInterval >=", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalLessThan(Integer value) {
            addCriterion("saveInterval <", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("saveInterval <=", value, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalIn(List<Integer> values) {
            addCriterion("saveInterval in", values, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalNotIn(List<Integer> values) {
            addCriterion("saveInterval not in", values, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalBetween(Integer value1, Integer value2) {
            addCriterion("saveInterval between", value1, value2, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andSaveIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("saveInterval not between", value1, value2, "saveInterval");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1IsNull() {
            addCriterion("lowAlarmLimit1 is null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1IsNotNull() {
            addCriterion("lowAlarmLimit1 is not null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1EqualTo(Float value) {
            addCriterion("lowAlarmLimit1 =", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1NotEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 <>", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1GreaterThan(Float value) {
            addCriterion("lowAlarmLimit1 >", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1GreaterThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 >=", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1LessThan(Float value) {
            addCriterion("lowAlarmLimit1 <", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1LessThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit1 <=", value, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1In(List<Float> values) {
            addCriterion("lowAlarmLimit1 in", values, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1NotIn(List<Float> values) {
            addCriterion("lowAlarmLimit1 not in", values, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1Between(Float value1, Float value2) {
            addCriterion("lowAlarmLimit1 between", value1, value2, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit1NotBetween(Float value1, Float value2) {
            addCriterion("lowAlarmLimit1 not between", value1, value2, "lowAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1IsNull() {
            addCriterion("hiAlarmLimit1 is null");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1IsNotNull() {
            addCriterion("hiAlarmLimit1 is not null");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1EqualTo(Float value) {
            addCriterion("hiAlarmLimit1 =", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1NotEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 <>", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1GreaterThan(Float value) {
            addCriterion("hiAlarmLimit1 >", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1GreaterThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 >=", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1LessThan(Float value) {
            addCriterion("hiAlarmLimit1 <", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1LessThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit1 <=", value, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1In(List<Float> values) {
            addCriterion("hiAlarmLimit1 in", values, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1NotIn(List<Float> values) {
            addCriterion("hiAlarmLimit1 not in", values, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1Between(Float value1, Float value2) {
            addCriterion("hiAlarmLimit1 between", value1, value2, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit1NotBetween(Float value1, Float value2) {
            addCriterion("hiAlarmLimit1 not between", value1, value2, "hiAlarmLimit1");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2IsNull() {
            addCriterion("lowAlarmLimit2 is null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2IsNotNull() {
            addCriterion("lowAlarmLimit2 is not null");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2EqualTo(Float value) {
            addCriterion("lowAlarmLimit2 =", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2NotEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 <>", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2GreaterThan(Float value) {
            addCriterion("lowAlarmLimit2 >", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2GreaterThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 >=", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2LessThan(Float value) {
            addCriterion("lowAlarmLimit2 <", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2LessThanOrEqualTo(Float value) {
            addCriterion("lowAlarmLimit2 <=", value, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2In(List<Float> values) {
            addCriterion("lowAlarmLimit2 in", values, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2NotIn(List<Float> values) {
            addCriterion("lowAlarmLimit2 not in", values, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2Between(Float value1, Float value2) {
            addCriterion("lowAlarmLimit2 between", value1, value2, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andLowAlarmLimit2NotBetween(Float value1, Float value2) {
            addCriterion("lowAlarmLimit2 not between", value1, value2, "lowAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2IsNull() {
            addCriterion("hiAlarmLimit2 is null");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2IsNotNull() {
            addCriterion("hiAlarmLimit2 is not null");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2EqualTo(Float value) {
            addCriterion("hiAlarmLimit2 =", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2NotEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 <>", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2GreaterThan(Float value) {
            addCriterion("hiAlarmLimit2 >", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2GreaterThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 >=", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2LessThan(Float value) {
            addCriterion("hiAlarmLimit2 <", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2LessThanOrEqualTo(Float value) {
            addCriterion("hiAlarmLimit2 <=", value, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2In(List<Float> values) {
            addCriterion("hiAlarmLimit2 in", values, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2NotIn(List<Float> values) {
            addCriterion("hiAlarmLimit2 not in", values, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2Between(Float value1, Float value2) {
            addCriterion("hiAlarmLimit2 between", value1, value2, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andHiAlarmLimit2NotBetween(Float value1, Float value2) {
            addCriterion("hiAlarmLimit2 not between", value1, value2, "hiAlarmLimit2");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNull() {
            addCriterion("onlineStatus is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNotNull() {
            addCriterion("onlineStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusEqualTo(Integer value) {
            addCriterion("onlineStatus =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(Integer value) {
            addCriterion("onlineStatus <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(Integer value) {
            addCriterion("onlineStatus >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("onlineStatus >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(Integer value) {
            addCriterion("onlineStatus <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(Integer value) {
            addCriterion("onlineStatus <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<Integer> values) {
            addCriterion("onlineStatus in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<Integer> values) {
            addCriterion("onlineStatus not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(Integer value1, Integer value2) {
            addCriterion("onlineStatus between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("onlineStatus not between", value1, value2, "onlineStatus");
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