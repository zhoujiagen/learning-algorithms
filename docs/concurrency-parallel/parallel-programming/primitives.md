# Primitives

## Resources

GCC

- [6.54 Legacy __sync Built-in Functions for Atomic Memory Access](https://gcc.gnu.org/onlinedocs/gcc-11.1.0/gcc/_005f_005fsync-Builtins.html#g_t_005f_005fsync-Builtins)
- [6.55 Built-in Functions for Memory Model Aware Atomic Operations](https://gcc.gnu.org/onlinedocs/gcc-11.1.0/gcc/_005f_005fatomic-Builtins.html#g_t_005f_005fatomic-Builtins): [C++11 memory model](https://en.cppreference.com/w/cpp/language/memory_model), [GCC wiki on atomic synchronization](http://gcc.gnu.org/wiki/Atomic/GCCMM/AtomicSync)

POSIX.1-2017

- Base Definitions > Headers > `<pthread.h>`: https://pubs.opengroup.org/onlinepubs/9699919799.2018edition/

Linux

- [Core API Documentation](https://www.kernel.org/doc/html/latest/core-api/index.html) > Concurrency primitives: `refcount_t`, IRQ, `local_t`, padata, RCU
- [locking](https://www.kernel.org/doc/html/latest/locking/index.html): Sleeping locks, CPU local locks, Spinning locks, mutex, Sequence counters(`seqcount_t`), Sequential locks(`seqlock_t`), futex
- [Atomic Types](https://www.kernel.org/doc/html/latest/staging/index.html#atomic-types): `atomic_t`, `atomic64_t`, `atomic_long_t`, `smp_mb()`
- [Atomic bitops](https://www.kernel.org/doc/html/latest/staging/index.html#atomic-bitops)
- [Memory Barriers](https://www.kernel.org/doc/html/latest/staging/index.html#memory-barriers)

## POSIX `<pthread.h>`

Types(in `<sys/types/h>`)

``` c
pthread_attr_t
pthread_barrier_t
pthread_barrierattr_t
pthread_cond_t
pthread_condattr_t
pthread_key_t
pthread_mutex_t
pthread_mutexattr_t
pthread_once_t
pthread_rwlock_t
pthread_rwlockattr_t
pthread_spinlock_t
pthread_t
```

Functions:

``` c
PTHREAD_COND_INITIALIZER    // Initializer for pthread_cond_t
PTHREAD_MUTEX_INITIALIZER   // Initializer for pthread_mutex_t
PTHREAD_RWLOCK_INITIALIZER  // Initializer for pthread_rwlock_t

int   pthread_atfork(void (*)(void), void (*)(void), void(*)(void));
int   pthread_attr_destroy(pthread_attr_t *);
int   pthread_attr_getdetachstate(const pthread_attr_t *, int *);
int   pthread_attr_getguardsize(const pthread_attr_t *restrict, size_t *restrict);
// [TPS]
int   pthread_attr_getinheritsched(const pthread_attr_t *restrict, int *restrict);

int   pthread_attr_getschedparam(const pthread_attr_t *restrict, struct sched_param *restrict);
// [TPS]
int   pthread_attr_getschedpolicy(const pthread_attr_t *restrict, int *restrict);
int   pthread_attr_getscope(const pthread_attr_t *restrict, int *restrict);

// [TSA TSS]
int   pthread_attr_getstack(const pthread_attr_t *restrict, void **restrict, size_t *restrict);

// [TSS]
int   pthread_attr_getstacksize(const pthread_attr_t *restrict, size_t *restrict);

int   pthread_attr_init(pthread_attr_t *);
int   pthread_attr_setdetachstate(pthread_attr_t *, int);
int   pthread_attr_setguardsize(pthread_attr_t *, size_t);
// [TPS]
int   pthread_attr_setinheritsched(pthread_attr_t *, int);

int   pthread_attr_setschedparam(pthread_attr_t *restrict, const struct sched_param *restrict);
// [TPS]
int   pthread_attr_setschedpolicy(pthread_attr_t *, int);
int   pthread_attr_setscope(pthread_attr_t *, int);

// [TSA TSS]
int   pthread_attr_setstack(pthread_attr_t *, void *, size_t);

// [TSS]
int   pthread_attr_setstacksize(pthread_attr_t *, size_t);

int   pthread_barrier_destroy(pthread_barrier_t *);
int   pthread_barrier_init(pthread_barrier_t *restrict, const pthread_barrierattr_t *restrict, unsigned);
int   pthread_barrier_wait(pthread_barrier_t *);
int   pthread_barrierattr_destroy(pthread_barrierattr_t *);
// [TSH]
int   pthread_barrierattr_getpshared(const pthread_barrierattr_t *restrict, int *restrict);

int   pthread_barrierattr_init(pthread_barrierattr_t *);
// [TSH]
int   pthread_barrierattr_setpshared(pthread_barrierattr_t *, int);

int   pthread_cancel(pthread_t);
int   pthread_cond_broadcast(pthread_cond_t *);
int   pthread_cond_destroy(pthread_cond_t *);
int   pthread_cond_init(pthread_cond_t *restrict, const pthread_condattr_t *restrict);
int   pthread_cond_signal(pthread_cond_t *);
int   pthread_cond_timedwait(pthread_cond_t *restrict, pthread_mutex_t *restrict, const struct timespec *restrict);
int   pthread_cond_wait(pthread_cond_t *restrict, pthread_mutex_t *restrict);
int   pthread_condattr_destroy(pthread_condattr_t *);
int   pthread_condattr_getclock(const pthread_condattr_t *restrict, clockid_t *restrict);
// [TSH]
int   pthread_condattr_getpshared(const pthread_condattr_t *restrict, int *restrict);

int   pthread_condattr_init(pthread_condattr_t *);
int   pthread_condattr_setclock(pthread_condattr_t *, clockid_t);
// [TSH]
int   pthread_condattr_setpshared(pthread_condattr_t *, int);

int   pthread_create(pthread_t *restrict, const pthread_attr_t *restrict, void *(*)(void*), void *restrict);
int   pthread_detach(pthread_t);
int   pthread_equal(pthread_t, pthread_t);
void  pthread_exit(void *);
// [OB XSI]
int   pthread_getconcurrency(void);

// [TCT]
int   pthread_getcpuclockid(pthread_t, clockid_t *);

// [TPS]
int   pthread_getschedparam(pthread_t, int *restrict, struct sched_param *restrict);

void *pthread_getspecific(pthread_key_t);
int   pthread_join(pthread_t, void **);
int   pthread_key_create(pthread_key_t *, void (*)(void*));
int   pthread_key_delete(pthread_key_t);
int   pthread_mutex_consistent(pthread_mutex_t *);
int   pthread_mutex_destroy(pthread_mutex_t *);
// [RPP|TPP]
int   pthread_mutex_getprioceiling(const pthread_mutex_t *restrict, int *restrict);

int   pthread_mutex_init(pthread_mutex_t *restrict, const pthread_mutexattr_t *restrict);
int   pthread_mutex_lock(pthread_mutex_t *);
// [RPP|TPP]
int   pthread_mutex_setprioceiling(pthread_mutex_t *restrict, int, int *restrict);

int   pthread_mutex_timedlock(pthread_mutex_t *restrict, const struct timespec *restrict);
int   pthread_mutex_trylock(pthread_mutex_t *);
int   pthread_mutex_unlock(pthread_mutex_t *);
int   pthread_mutexattr_destroy(pthread_mutexattr_t *);
// [RPP|TPP]
int   pthread_mutexattr_getprioceiling(const pthread_mutexattr_t *restrict, int *restrict);

// [MC1]
int   pthread_mutexattr_getprotocol(const pthread_mutexattr_t *restrict, int *restrict);

// [TSH]
int   pthread_mutexattr_getpshared(const pthread_mutexattr_t *restrict, int *restrict);

int   pthread_mutexattr_getrobust(const pthread_mutexattr_t *restrict, int *restrict);
int   pthread_mutexattr_gettype(const pthread_mutexattr_t *restrict, int *restrict);
int   pthread_mutexattr_init(pthread_mutexattr_t *);
// [RPP|TPP]
int   pthread_mutexattr_setprioceiling(pthread_mutexattr_t *, int);

// [MC1]
int   pthread_mutexattr_setprotocol(pthread_mutexattr_t *, int);

// [TSH]
int   pthread_mutexattr_setpshared(pthread_mutexattr_t *, int);

int   pthread_mutexattr_setrobust(pthread_mutexattr_t *, int);
int   pthread_mutexattr_settype(pthread_mutexattr_t *, int);
int   pthread_once(pthread_once_t *, void (*)(void));
int   pthread_rwlock_destroy(pthread_rwlock_t *);
int   pthread_rwlock_init(pthread_rwlock_t *restrict, const pthread_rwlockattr_t *restrict);
int   pthread_rwlock_rdlock(pthread_rwlock_t *);
int   pthread_rwlock_timedrdlock(pthread_rwlock_t *restrict, const struct timespec *restrict);
int   pthread_rwlock_timedwrlock(pthread_rwlock_t *restrict, const struct timespec *restrict);
int   pthread_rwlock_tryrdlock(pthread_rwlock_t *);
int   pthread_rwlock_trywrlock(pthread_rwlock_t *);
int   pthread_rwlock_unlock(pthread_rwlock_t *);
int   pthread_rwlock_wrlock(pthread_rwlock_t *);
int   pthread_rwlockattr_destroy(pthread_rwlockattr_t *);
// [TSH]
int   pthread_rwlockattr_getpshared(const pthread_rwlockattr_t *restrict, int *restrict);

int   pthread_rwlockattr_init(pthread_rwlockattr_t *);
// [TSH]
int   pthread_rwlockattr_setpshared(pthread_rwlockattr_t *, int);

pthread_t pthread_self(void);
int   pthread_setcancelstate(int, int *);
int   pthread_setcanceltype(int, int *);
// [OB XSI]
int   pthread_setconcurrency(int);

// [TPS]
int   pthread_setschedparam(pthread_t, int, const struct sched_param *);
int   pthread_setschedprio(pthread_t, int);

int   pthread_setspecific(pthread_key_t, const void *);
int   pthread_spin_destroy(pthread_spinlock_t *);
int   pthread_spin_init(pthread_spinlock_t *, int);
int   pthread_spin_lock(pthread_spinlock_t *);
int   pthread_spin_trylock(pthread_spinlock_t *);
int   pthread_spin_unlock(pthread_spinlock_t *);
void  pthread_testcancel(void);

pthread_cleanup_pop()
pthread_cleanup_push()
```

## GCC `__sync`

> These functions are implemented in terms of the ‘__atomic’ builtins. They should not be used for new code which should use the ‘__atomic’ builtins instead.

``` c
type __sync_fetch_and_add (type *ptr, type value, ...)
type __sync_fetch_and_sub (type *ptr, type value, ...)
type __sync_fetch_and_or (type *ptr, type value, ...)
type __sync_fetch_and_and (type *ptr, type value, ...)
type __sync_fetch_and_xor (type *ptr, type value, ...)
type __sync_fetch_and_nand (type *ptr, type value, ...)

type __sync_add_and_fetch (type *ptr, type value, ...)
type __sync_sub_and_fetch (type *ptr, type value, ...)
type __sync_or_and_fetch (type *ptr, type value, ...)
type __sync_and_and_fetch (type *ptr, type value, ...)
type __sync_xor_and_fetch (type *ptr, type value, ...)
type __sync_nand_and_fetch (type *ptr, type value, ...)

bool __sync_bool_compare_and_swap (type *ptr, type oldval, type newval, ...)
type __sync_val_compare_and_swap (type *ptr, type oldval, type newval, ...)

__sync_synchronize (...)
type __sync_lock_test_and_set (type *ptr, type value, ...)
void __sync_lock_release (type *ptr, ...)
```

## GCC `__atomic`

Memory Order:

|<div style="width: 150px">Value</div>|Description|
|:---|:---|
|`__ATOMIC_RELAXED` | Implies no inter-thread ordering constraints.|
|`__ATOMIC_CONSUME` | This is currently implemented using the stronger __ATOMIC_ACQUIRE memory order because of a deficiency in C++11’s semantics for memory_order_consume.|
|`__ATOMIC_ACQUIRE` | Creates an inter-thread happens-before constraint from the release (or stronger) semantic store to this acquire load. Can prevent hoisting of code to before the operation.|
|`__ATOMIC_RELEASE` | Creates an inter-thread happens-before constraint to acquire (or stronger) semantic loads that read from this release store. Can prevent sinking of code to after the operation.|
|`__ATOMIC_ACQ_REL` | Combines the effects of both `__ATOMIC_ACQUIRE` and `__ATOMIC_RELEASE`.|
|`__ATOMIC_SEQ_CST` | Enforces total ordering with all other `__ATOMIC_SEQ_CST` operations.|


``` c
type __atomic_load_n (type *ptr, int memorder)
void __atomic_load (type *ptr, type *ret, int memorder)
void __atomic_store_n (type *ptr, type val, int memorder)
void __atomic_store (type *ptr, type *val, int memorder)
type __atomic_exchange_n (type *ptr, type val, int memorder)
void __atomic_exchange (type *ptr, type *val, type *ret, int memorder)
bool __atomic_compare_exchange_n (type *ptr, type *expected, type desired,
  bool weak, int success_memorder, int failure_memorder)
bool __atomic_compare_exchange (type *ptr, type *expected, type *desired,
  bool weak, int success_memorder, int failure_memorder)

type __atomic_add_fetch (type *ptr, type val, int memorder)
type __atomic_sub_fetch (type *ptr, type val, int memorder)
type __atomic_and_fetch (type *ptr, type val, int memorder)
type __atomic_xor_fetch (type *ptr, type val, int memorder)
type __atomic_or_fetch (type *ptr, type val, int memorder)
type __atomic_nand_fetch (type *ptr, type val, int memorder)

type __atomic_fetch_add (type *ptr, type val, int memorder)
type __atomic_fetch_sub (type *ptr, type val, int memorder)
type __atomic_fetch_and (type *ptr, type val, int memorder)
type __atomic_fetch_xor (type *ptr, type val, int memorder)
type __atomic_fetch_or (type *ptr, type val, int memorder)
type __atomic_fetch_nand (type *ptr, type val, int memorder)

bool __atomic_test_and_set (void *ptr, int memorder)
void __atomic_clear (bool *ptr, int memorder)
void __atomic_thread_fence (int memorder)
void __atomic_signal_fence (int memorder)
bool __atomic_always_lock_free (size_t size, void *ptr)
bool __atomic_is_lock_free (size_t size, void *ptr)
```
