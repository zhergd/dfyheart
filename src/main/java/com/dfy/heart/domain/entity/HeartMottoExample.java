package com.dfy.heart.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class HeartMottoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HeartMottoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andMottoIdIsNull() {
            addCriterion("motto_id is null");
            return (Criteria) this;
        }

        public Criteria andMottoIdIsNotNull() {
            addCriterion("motto_id is not null");
            return (Criteria) this;
        }

        public Criteria andMottoIdEqualTo(Integer value) {
            addCriterion("motto_id =", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdNotEqualTo(Integer value) {
            addCriterion("motto_id <>", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdGreaterThan(Integer value) {
            addCriterion("motto_id >", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("motto_id >=", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdLessThan(Integer value) {
            addCriterion("motto_id <", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdLessThanOrEqualTo(Integer value) {
            addCriterion("motto_id <=", value, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdIn(List<Integer> values) {
            addCriterion("motto_id in", values, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdNotIn(List<Integer> values) {
            addCriterion("motto_id not in", values, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdBetween(Integer value1, Integer value2) {
            addCriterion("motto_id between", value1, value2, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("motto_id not between", value1, value2, "mottoId");
            return (Criteria) this;
        }

        public Criteria andMottoTextIsNull() {
            addCriterion("motto_text is null");
            return (Criteria) this;
        }

        public Criteria andMottoTextIsNotNull() {
            addCriterion("motto_text is not null");
            return (Criteria) this;
        }

        public Criteria andMottoTextEqualTo(String value) {
            addCriterion("motto_text =", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextNotEqualTo(String value) {
            addCriterion("motto_text <>", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextGreaterThan(String value) {
            addCriterion("motto_text >", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextGreaterThanOrEqualTo(String value) {
            addCriterion("motto_text >=", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextLessThan(String value) {
            addCriterion("motto_text <", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextLessThanOrEqualTo(String value) {
            addCriterion("motto_text <=", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextLike(String value) {
            addCriterion("motto_text like", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextNotLike(String value) {
            addCriterion("motto_text not like", value, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextIn(List<String> values) {
            addCriterion("motto_text in", values, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextNotIn(List<String> values) {
            addCriterion("motto_text not in", values, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextBetween(String value1, String value2) {
            addCriterion("motto_text between", value1, value2, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoTextNotBetween(String value1, String value2) {
            addCriterion("motto_text not between", value1, value2, "mottoText");
            return (Criteria) this;
        }

        public Criteria andMottoStatusIsNull() {
            addCriterion("motto_status is null");
            return (Criteria) this;
        }

        public Criteria andMottoStatusIsNotNull() {
            addCriterion("motto_status is not null");
            return (Criteria) this;
        }

        public Criteria andMottoStatusEqualTo(Integer value) {
            addCriterion("motto_status =", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusNotEqualTo(Integer value) {
            addCriterion("motto_status <>", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusGreaterThan(Integer value) {
            addCriterion("motto_status >", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("motto_status >=", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusLessThan(Integer value) {
            addCriterion("motto_status <", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("motto_status <=", value, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusIn(List<Integer> values) {
            addCriterion("motto_status in", values, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusNotIn(List<Integer> values) {
            addCriterion("motto_status not in", values, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusBetween(Integer value1, Integer value2) {
            addCriterion("motto_status between", value1, value2, "mottoStatus");
            return (Criteria) this;
        }

        public Criteria andMottoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("motto_status not between", value1, value2, "mottoStatus");
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