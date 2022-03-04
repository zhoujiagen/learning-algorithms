# Instruction Reference

## Terminator Instructions
### ‘ret’ Instruction
### ‘br’ Instruction
### ‘switch’ Instruction
### Implementation:
### ‘indirectbr’ Instruction
### Implementation:
### ‘invoke’ Instruction
### ‘callbr’ Instruction
### ‘resume’ Instruction
### ‘catchswitch’ Instruction
### ‘catchret’ Instruction
### ‘cleanupret’ Instruction
### ‘unreachable’ Instruction

## Unary Operations
### ‘fneg’ Instruction

## Binary Operations
### ‘add’ Instruction
### ‘fadd’ Instruction
### ‘sub’ Instruction
### ‘fsub’ Instruction
### ‘mul’ Instruction
### ‘fmul’ Instruction
### ‘udiv’ Instruction
### ‘sdiv’ Instruction
### ‘fdiv’ Instruction
### ‘urem’ Instruction
### ‘srem’ Instruction
### ‘frem’ Instruction

## Bitwise Binary Operations
### ‘shl’ Instruction
### ‘lshr’ Instruction
### ‘ashr’ Instruction
### ‘and’ Instruction
### ‘or’ Instruction
### ‘xor’ Instruction

## Vector Operations
### ‘extractelement’ Instruction
### ‘insertelement’ Instruction
### ‘shufflevector’ Instruction

## Aggregate Operations
### ‘extractvalue’ Instruction
### ‘insertvalue’ Instruction

## Memory Access and Addressing Operations
### ‘alloca’ Instruction
### ‘load’ Instruction
### ‘store’ Instruction
### ‘fence’ Instruction
### ‘cmpxchg’ Instruction
### ‘atomicrmw’ Instruction
### ‘getelementptr’ Instruction
### Vector of pointers:

## Conversion Operations
### ‘trunc .. to’ Instruction
### ‘zext .. to’ Instruction
### ‘sext .. to’ Instruction
### ‘fptrunc .. to’ Instruction
### ‘fpext .. to’ Instruction
### ‘fptoui .. to’ Instruction
### ‘fptosi .. to’ Instruction
### ‘uitofp .. to’ Instruction
### ‘sitofp .. to’ Instruction
### ‘ptrtoint .. to’ Instruction
### ‘inttoptr .. to’ Instruction
### ‘bitcast .. to’ Instruction
### ‘addrspacecast .. to’ Instruction

## Other Operations
### ‘icmp’ Instruction
### ‘fcmp’ Instruction
### ‘phi’ Instruction
### ‘select’ Instruction
### ‘freeze’ Instruction
### ‘call’ Instruction
### ‘va_arg’ Instruction
### ‘landingpad’ Instruction
### ‘catchpad’ Instruction
### ‘cleanuppad’ Instruction

# Intrinsic Functions
## Variable Argument Handling Intrinsics
### ‘llvm.va_start’ Intrinsic
### ‘llvm.va_end’ Intrinsic
### ‘llvm.va_copy’ Intrinsic

## Accurate Garbage Collection Intrinsics
### ‘llvm.gcroot’ Intrinsic
### ‘llvm.gcread’ Intrinsic
### ‘llvm.gcwrite’ Intrinsic
### ‘llvm.experimental.gc.statepoint’ Intrinsic
### ‘llvm.experimental.gc.result’ Intrinsic
### ‘llvm.experimental.gc.relocate’ Intrinsic
### ‘llvm.experimental.gc.get.pointer.base’ Intrinsic
### ‘llvm.experimental.gc.get.pointer.offset’ Intrinsic

## Code Generator Intrinsics
### ‘llvm.returnaddress’ Intrinsic
### ‘llvm.addressofreturnaddress’ Intrinsic
### ‘llvm.sponentry’ Intrinsic
### ‘llvm.frameaddress’ Intrinsic
### ‘llvm.swift.async.context.addr’ Intrinsic
### ‘llvm.localescape’ and ‘llvm.localrecover’ Intrinsics
### ‘llvm.seh.try.begin’ and ‘llvm.seh.try.end’ Intrinsics
### ‘llvm.seh.scope.begin’ and ‘llvm.seh.scope.end’ Intrinsics
### ‘llvm.read_register’, ‘llvm.read_volatile_register’, and ‘llvm.write_register’ Intrinsics
### ‘llvm.stacksave’ Intrinsic
### ‘llvm.stackrestore’ Intrinsic
### ‘llvm.get.dynamic.area.offset’ Intrinsic
### ‘llvm.prefetch’ Intrinsic
### ‘llvm.pcmarker’ Intrinsic
### ‘llvm.readcyclecounter’ Intrinsic
### ‘llvm.clear_cache’ Intrinsic
### ‘llvm.instrprof.increment’ Intrinsic
### ‘llvm.instrprof.increment.step’ Intrinsic
### ‘llvm.instrprof.cover’ Intrinsic
### ‘llvm.instrprof.value.profile’ Intrinsic
### ‘llvm.thread.pointer’ Intrinsic
### ‘llvm.call.preallocated.setup’ Intrinsic
### ‘llvm.call.preallocated.arg’ Intrinsic
### ‘llvm.call.preallocated.teardown’ Intrinsic

## Standard C/C++ Library Intrinsics
### ‘llvm.abs.*’ Intrinsic
### ‘llvm.smax.*’ Intrinsic
### ‘llvm.smin.*’ Intrinsic
### ‘llvm.umax.*’ Intrinsic
### ‘llvm.umin.*’ Intrinsic
### ‘llvm.memcpy’ Intrinsic
### ‘llvm.memcpy.inline’ Intrinsic
### ‘llvm.memmove’ Intrinsic
### ‘llvm.memset.*’ Intrinsics
### ‘llvm.sqrt.*’ Intrinsic
### ‘llvm.powi.*’ Intrinsic
### ‘llvm.sin.*’ Intrinsic
### ‘llvm.cos.*’ Intrinsic
### ‘llvm.pow.*’ Intrinsic
### ‘llvm.exp.*’ Intrinsic
### ‘llvm.exp2.*’ Intrinsic
### ‘llvm.log.*’ Intrinsic
### ‘llvm.log10.*’ Intrinsic
### ‘llvm.log2.*’ Intrinsic
### ‘llvm.fma.*’ Intrinsic
### ‘llvm.fabs.*’ Intrinsic
### ‘llvm.minnum.*’ Intrinsic
### ‘llvm.maxnum.*’ Intrinsic
### ‘llvm.minimum.*’ Intrinsic
### ‘llvm.maximum.*’ Intrinsic
### ‘llvm.copysign.*’ Intrinsic
### ‘llvm.floor.*’ Intrinsic
### ‘llvm.ceil.*’ Intrinsic
### ‘llvm.trunc.*’ Intrinsic
### ‘llvm.rint.*’ Intrinsic
### ‘llvm.nearbyint.*’ Intrinsic
### ‘llvm.round.*’ Intrinsic
### ‘llvm.roundeven.*’ Intrinsic
### ‘llvm.lround.*’ Intrinsic
### ‘llvm.llround.*’ Intrinsic
### ‘llvm.lrint.*’ Intrinsic
### ‘llvm.llrint.*’ Intrinsic

## Bit Manipulation Intrinsics
### ‘llvm.bitreverse.*’ Intrinsics
### ‘llvm.bswap.*’ Intrinsics
### ‘llvm.ctpop.*’ Intrinsic
### ‘llvm.ctlz.*’ Intrinsic
### ‘llvm.cttz.*’ Intrinsic
### ‘llvm.fshl.*’ Intrinsic
### ‘llvm.fshr.*’ Intrinsic

## Arithmetic with Overflow Intrinsics
### ‘llvm.sadd.with.overflow.*’ Intrinsics
### ‘llvm.uadd.with.overflow.*’ Intrinsics
### ‘llvm.ssub.with.overflow.*’ Intrinsics
### ‘llvm.usub.with.overflow.*’ Intrinsics
### ‘llvm.smul.with.overflow.*’ Intrinsics
### ‘llvm.umul.with.overflow.*’ Intrinsics

## Saturation Arithmetic Intrinsics
### ‘llvm.sadd.sat.*’ Intrinsics
### ‘llvm.uadd.sat.*’ Intrinsics
### ‘llvm.ssub.sat.*’ Intrinsics
### ‘llvm.usub.sat.*’ Intrinsics
### ‘llvm.sshl.sat.*’ Intrinsics
### ‘llvm.ushl.sat.*’ Intrinsics

## Fixed Point Arithmetic Intrinsics
### ‘llvm.smul.fix.*’ Intrinsics
### ‘llvm.umul.fix.*’ Intrinsics
### ‘llvm.smul.fix.sat.*’ Intrinsics
### ‘llvm.umul.fix.sat.*’ Intrinsics
### ‘llvm.sdiv.fix.*’ Intrinsics
### ‘llvm.udiv.fix.*’ Intrinsics
### ‘llvm.sdiv.fix.sat.*’ Intrinsics
### ‘llvm.udiv.fix.sat.*’ Intrinsics

## Specialised Arithmetic Intrinsics
### ‘llvm.canonicalize.*’ Intrinsic
### ‘llvm.fmuladd.*’ Intrinsic

## Hardware-Loop Intrinsics
### ‘llvm.set.loop.iterations.*’ Intrinsic
### ‘llvm.start.loop.iterations.*’ Intrinsic
### ‘llvm.test.set.loop.iterations.*’ Intrinsic
### ‘llvm.test.start.loop.iterations.*’ Intrinsic
### ‘llvm.loop.decrement.reg.*’ Intrinsic
### ‘llvm.loop.decrement.*’ Intrinsic

## Vector Reduction Intrinsics
### ‘llvm.vector.reduce.add.*’ Intrinsic
### ‘llvm.vector.reduce.fadd.*’ Intrinsic
### ‘llvm.vector.reduce.mul.*’ Intrinsic
### ‘llvm.vector.reduce.fmul.*’ Intrinsic
### ‘llvm.vector.reduce.and.*’ Intrinsic
### ‘llvm.vector.reduce.or.*’ Intrinsic
### ‘llvm.vector.reduce.xor.*’ Intrinsic
### ‘llvm.vector.reduce.smax.*’ Intrinsic
### ‘llvm.vector.reduce.smin.*’ Intrinsic
### ‘llvm.vector.reduce.umax.*’ Intrinsic
### ‘llvm.vector.reduce.umin.*’ Intrinsic
### ‘llvm.vector.reduce.fmax.*’ Intrinsic
### ‘llvm.vector.reduce.fmin.*’ Intrinsic
### ‘llvm.experimental.vector.insert’ Intrinsic
### ‘llvm.experimental.vector.extract’ Intrinsic
### ‘llvm.experimental.vector.reverse’ Intrinsic
### ‘llvm.experimental.vector.splice’ Intrinsic
### ‘llvm.experimental.stepvector’ Intrinsic

## Matrix Intrinsics
### ‘llvm.matrix.transpose.*’ Intrinsic
### ‘llvm.matrix.multiply.*’ Intrinsic
### ‘llvm.matrix.column.major.load.*’ Intrinsic
### ‘llvm.matrix.column.major.store.*’ Intrinsic

## Half Precision Floating-Point Intrinsics
### ‘llvm.convert.to.fp16’ Intrinsic
### ‘llvm.convert.from.fp16’ Intrinsic

## Saturating floating-point to integer conversions
### ‘llvm.fptoui.sat.*’ Intrinsic
### ‘llvm.fptosi.sat.*’ Intrinsic

## Debugger Intrinsics
## Exception Handling Intrinsics
## Pointer Authentication Intrinsics

## Trampoline Intrinsics
### ‘llvm.init.trampoline’ Intrinsic
### ‘llvm.adjust.trampoline’ Intrinsic

## Vector Predication Intrinsics
### Optimization Hint
### ‘llvm.vp.select.*’ Intrinsics
### ‘llvm.vp.merge.*’ Intrinsics
### ‘llvm.vp.add.*’ Intrinsics
### ‘llvm.vp.sub.*’ Intrinsics
### ‘llvm.vp.mul.*’ Intrinsics
### ‘llvm.vp.sdiv.*’ Intrinsics
### ‘llvm.vp.udiv.*’ Intrinsics
### ‘llvm.vp.srem.*’ Intrinsics
### ‘llvm.vp.urem.*’ Intrinsics
### ‘llvm.vp.ashr.*’ Intrinsics
### ‘llvm.vp.lshr.*’ Intrinsics
### ‘llvm.vp.shl.*’ Intrinsics
### ‘llvm.vp.or.*’ Intrinsics
### ‘llvm.vp.and.*’ Intrinsics
### ‘llvm.vp.xor.*’ Intrinsics
### ‘llvm.vp.fadd.*’ Intrinsics
### ‘llvm.vp.fsub.*’ Intrinsics
### ‘llvm.vp.fmul.*’ Intrinsics
### ‘llvm.vp.fdiv.*’ Intrinsics
### ‘llvm.vp.frem.*’ Intrinsics
### ‘llvm.vp.fneg.*’ Intrinsics
### ‘llvm.vp.fma.*’ Intrinsics
### ‘llvm.vp.reduce.add.*’ Intrinsics
### ‘llvm.vp.reduce.fadd.*’ Intrinsics
### ‘llvm.vp.reduce.mul.*’ Intrinsics
### ‘llvm.vp.reduce.fmul.*’ Intrinsics
### ‘llvm.vp.reduce.and.*’ Intrinsics
### ‘llvm.vp.reduce.or.*’ Intrinsics
### ‘llvm.vp.reduce.xor.*’ Intrinsics
### ‘llvm.vp.reduce.smax.*’ Intrinsics
### ‘llvm.vp.reduce.smin.*’ Intrinsics
### ‘llvm.vp.reduce.umax.*’ Intrinsics
### ‘llvm.vp.reduce.umin.*’ Intrinsics
### ‘llvm.vp.reduce.fmax.*’ Intrinsics
### ‘llvm.vp.reduce.fmin.*’ Intrinsics
### ‘llvm.get.active.lane.mask.*’ Intrinsics
### ‘llvm.experimental.vp.splice’ Intrinsic
### ‘llvm.vp.load’ Intrinsic
### ‘llvm.vp.store’ Intrinsic
### ‘llvm.vp.gather’ Intrinsic
### ‘llvm.vp.scatter’ Intrinsic
### ‘llvm.vp.fptosi.*’ Intrinsics
### ‘llvm.vp.sitofp.*’ Intrinsics

## Masked Vector Load and Store Intrinsics
### ‘llvm.masked.load.*’ Intrinsics
### ‘llvm.masked.store.*’ Intrinsics

## Masked Vector Gather and Scatter Intrinsics
### ‘llvm.masked.gather.*’ Intrinsics
### ‘llvm.masked.scatter.*’ Intrinsics

## Masked Vector Expanding Load and Compressing Store Intrinsics
### ‘llvm.masked.expandload.*’ Intrinsics
### ‘llvm.masked.compressstore.*’ Intrinsics

## Memory Use Markers
### ‘llvm.lifetime.start’ Intrinsic
### ‘llvm.lifetime.end’ Intrinsic
### ‘llvm.invariant.start’ Intrinsic
### ‘llvm.invariant.end’ Intrinsic
### ‘llvm.launder.invariant.group’ Intrinsic
### ‘llvm.strip.invariant.group’ Intrinsic

## Constrained Floating-Point Intrinsics
### ‘llvm.experimental.constrained.fadd’ Intrinsic
### ‘llvm.experimental.constrained.fsub’ Intrinsic
### ‘llvm.experimental.constrained.fmul’ Intrinsic
### ‘llvm.experimental.constrained.fdiv’ Intrinsic
### ‘llvm.experimental.constrained.frem’ Intrinsic
### ‘llvm.experimental.constrained.fma’ Intrinsic
### ‘llvm.experimental.constrained.fptoui’ Intrinsic
### ‘llvm.experimental.constrained.fptosi’ Intrinsic
### ‘llvm.experimental.constrained.uitofp’ Intrinsic
### ‘llvm.experimental.constrained.sitofp’ Intrinsic
### ‘llvm.experimental.constrained.fptrunc’ Intrinsic
### ‘llvm.experimental.constrained.fpext’ Intrinsic
### ‘llvm.experimental.constrained.fcmp’ and ‘llvm.experimental.constrained.fcmps’ Intrinsics
### ‘llvm.experimental.constrained.fmuladd’ Intrinsic

## Constrained libm-equivalent Intrinsics
### ‘llvm.experimental.constrained.sqrt’ Intrinsic
### ‘llvm.experimental.constrained.pow’ Intrinsic
### ‘llvm.experimental.constrained.powi’ Intrinsic
### ‘llvm.experimental.constrained.sin’ Intrinsic
### ‘llvm.experimental.constrained.cos’ Intrinsic
### ‘llvm.experimental.constrained.exp’ Intrinsic
### ‘llvm.experimental.constrained.exp2’ Intrinsic
### ‘llvm.experimental.constrained.log’ Intrinsic
### ‘llvm.experimental.constrained.log10’ Intrinsic
### ‘llvm.experimental.constrained.log2’ Intrinsic
### ‘llvm.experimental.constrained.rint’ Intrinsic
### ‘llvm.experimental.constrained.lrint’ Intrinsic
### ‘llvm.experimental.constrained.llrint’ Intrinsic
### ‘llvm.experimental.constrained.nearbyint’ Intrinsic
### ‘llvm.experimental.constrained.maxnum’ Intrinsic
### ‘llvm.experimental.constrained.minnum’ Intrinsic
### ‘llvm.experimental.constrained.maximum’ Intrinsic
### ‘llvm.experimental.constrained.minimum’ Intrinsic
### ‘llvm.experimental.constrained.ceil’ Intrinsic
### ‘llvm.experimental.constrained.floor’ Intrinsic
### ‘llvm.experimental.constrained.round’ Intrinsic
### ‘llvm.experimental.constrained.roundeven’ Intrinsic
### ‘llvm.experimental.constrained.lround’ Intrinsic
### ‘llvm.experimental.constrained.llround’ Intrinsic
### ‘llvm.experimental.constrained.trunc’ Intrinsic
### ‘llvm.experimental.noalias.scope.decl’ Intrinsic

## Floating Point Environment Manipulation intrinsics
### ‘llvm.flt.rounds’ Intrinsic
### ‘llvm.set.rounding’ Intrinsic

## General Intrinsics
### ‘llvm.var.annotation’ Intrinsic
### ‘llvm.ptr.annotation.*’ Intrinsic
### ‘llvm.annotation.*’ Intrinsic
### ‘llvm.codeview.annotation’ Intrinsic
### ‘llvm.trap’ Intrinsic
### ‘llvm.debugtrap’ Intrinsic
### ‘llvm.ubsantrap’ Intrinsic
### ‘llvm.stackprotector’ Intrinsic
### ‘llvm.stackguard’ Intrinsic
### ‘llvm.objectsize’ Intrinsic
### ‘llvm.expect’ Intrinsic
### ‘llvm.expect.with.probability’ Intrinsic
### ‘llvm.assume’ Intrinsic
### ‘llvm.ssa.copy’ Intrinsic
### ‘llvm.type.test’ Intrinsic
### ‘llvm.type.checked.load’ Intrinsic
### ‘llvm.arithmetic.fence’ Intrinsic
### ‘llvm.donothing’ Intrinsic
### ‘llvm.experimental.deoptimize’ Intrinsic
### ‘llvm.experimental.guard’ Intrinsic
### ‘llvm.experimental.widenable.condition’ Intrinsic
### ‘llvm.load.relative’ Intrinsic
### ‘llvm.sideeffect’ Intrinsic
### ‘llvm.is.constant.*’ Intrinsic
### ‘llvm.ptrmask’ Intrinsic
### ‘llvm.vscale’ Intrinsic

## Stack Map Intrinsics

## Element Wise Atomic Memory Intrinsics
### ‘llvm.memcpy.element.unordered.atomic’ Intrinsic
### ‘llvm.memmove.element.unordered.atomic’ Intrinsic
### ‘llvm.memset.element.unordered.atomic’ Intrinsic

## Objective-C ARC Runtime Intrinsics
### ‘llvm.objc.autorelease’ Intrinsic
### ‘llvm.objc.autoreleasePoolPop’ Intrinsic
### ‘llvm.objc.autoreleasePoolPush’ Intrinsic
### ‘llvm.objc.autoreleaseReturnValue’ Intrinsic
### ‘llvm.objc.copyWeak’ Intrinsic
### ‘llvm.objc.destroyWeak’ Intrinsic
### ‘llvm.objc.initWeak’ Intrinsic
### ‘llvm.objc.loadWeak’ Intrinsic
### ‘llvm.objc.loadWeakRetained’ Intrinsic
### ‘llvm.objc.moveWeak’ Intrinsic
### ‘llvm.objc.release’ Intrinsic
### ‘llvm.objc.retain’ Intrinsic
### ‘llvm.objc.retainAutorelease’ Intrinsic
### ‘llvm.objc.retainAutoreleaseReturnValue’ Intrinsic
### ‘llvm.objc.retainAutoreleasedReturnValue’ Intrinsic
### ‘llvm.objc.retainBlock’ Intrinsic
### ‘llvm.objc.storeStrong’ Intrinsic
### ‘llvm.objc.storeWeak’ Intrinsic
### Preserving Debug Information Intrinsics
### ‘llvm.preserve.array.access.index’ Intrinsic
### ‘llvm.preserve.union.access.index’ Intrinsic
### ‘llvm.preserve.struct.access.index’ Intrinsic
### ‘llvm.fptrunc.round’ Intrinsic
