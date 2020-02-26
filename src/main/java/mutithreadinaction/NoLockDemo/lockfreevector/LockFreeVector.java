/**
 * @Description: 无锁实现vector$
 * @Author: wpf
 * @Date: $
 */
package mutithreadinaction.NoLockDemo.lockfreevector;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class LockFreeVector<E> {

    private final Integer FIRST_BUCKET_SIZE = 8;

    private final Integer N_BUCKET = 30;

    // 使用二维数组作为内部存储
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;

    // 定义Descriptor元素，使用CAS操作写入新数据
    static class Descriptor<E> {
        public int size;

    }

    static class WriteDescriptor<E> {
        public E oldV;
        public E newV;
        public AtomicReferenceArray<E> addr;
        public int addr_ind;

        public WriteDescriptor(AtomicReferenceArray<E> addr, int addr_ind,
                               E oldV, E newV){
            this.addr = addr;
            this.addr_ind = addr_ind;
            this.oldV = oldV;
            this.newV = newV;
        }

        public void doIt(){
            addr.compareAndSet(addr_ind, oldV, newV);
        }
    }

    public LockFreeVector() {
        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(N_BUCKET);
        buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));

    }
}
