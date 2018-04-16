package uz.zgora.pl.raspberry.model;

import java.io.Serializable;

public class SingleConfiguration implements Serializable {
    private final int id;
    private final Type type;
    private final float kp;
    private final float ki;
    private final float kd;
    private final float tf;

    public static SingleConfiguration EMPTY(final Type type) {
        return new Builder()
                .type(type)
                .build();
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public float getKp() {
        return kp;
    }

    public float getKi() {
        return ki;
    }

    public float getKd() {
        return kd;
    }

    public float getTf() {
        return tf;
    }

    private SingleConfiguration(final Builder builder) {
        id = builder.id;
        type = builder.type;
        kp = builder.kp;
        ki = builder.ki;
        kd = builder.kd;
        tf = builder.tf;
    }

    public static final class Builder {
        private int id;
        private Type type;
        private float kp;
        private float ki;
        private float kd;
        private float tf;

        public Builder id(final int id) {
            this.id = id;
            return this;
        }

        public Builder type(final Type type) {
            this.type = type;
            return this;
        }

        public Builder kp(final float kp) {
            this.kp = kp;
            return this;
        }

        public Builder ki(final float ki) {
            this.ki = ki;
            return this;
        }

        public Builder kd(final float kd) {
            this.kd = kd;
            return this;
        }

        public Builder tf(final float tf) {
            this.tf = tf;
            return this;
        }

        public SingleConfiguration build() {
            return new SingleConfiguration(this);
        }
    }

    public enum Type {
        PITCH, ROLL, YAW, THRUST, UNKNOWN
    }
}
