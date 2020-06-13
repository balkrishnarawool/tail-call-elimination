package com.balarawool.tailcall;

import java.util.function.Supplier;

public abstract class TailCall<T> {
    public abstract T eval();
    public abstract boolean isSuspend();
    public abstract TailCall<T> resume();

    public static class Return<T> extends TailCall<T> {
        private T value;

        private Return(T value) {
            this.value = value;
        }

        @Override
        public T eval() {
            return value;
        }

        @Override
        public boolean isSuspend() {
            return false;
        }

        @Override
        public TailCall<T> resume() {
            throw new IllegalStateException("resume() called on Return");
        }
    }

    public static class Suspend<T> extends TailCall<T> {
        private Supplier<TailCall<T>> supplier;

        private Suspend(Supplier<TailCall<T>> supplier) {
            this.supplier = supplier;
        }

        @Override
        public T eval() {
            TailCall<T> tc = supplier.get();
            while(tc.isSuspend()) {
                tc = tc.resume();
            }
            return tc.eval();
        }

        @Override
        public boolean isSuspend() {
            return true;
        }

        @Override
        public TailCall<T> resume() {
            return supplier.get();
        }
    }

    public static <T> Return<T> ret(T value) {
        return new Return<>(value);
    }

    public static <T> Suspend<T> sus(Supplier<TailCall<T>> supplier) {
        return new Suspend<>(supplier);
    }
}
