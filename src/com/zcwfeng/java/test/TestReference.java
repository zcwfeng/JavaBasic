package com.zcwfeng.java.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * 测试java中的各种引用类型 <br/>
 * Date:2015年4月29日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestReference {
	// phantom 幽灵
	public static void main(String[] args) {
		Object weakObj, phantomObj;
		Reference ref;
		WeakReference weakRef;
		PhantomReference phantomRef;
		ReferenceQueue weakQueue, phantomQueue;

		weakObj = new String("Weak Reference");
		phantomObj = new String("phantom Reference");

		weakQueue = new ReferenceQueue();
		phantomQueue = new ReferenceQueue();

		weakRef = new WeakReference(weakObj, weakQueue);
		phantomRef = new PhantomReference(phantomObj, phantomQueue);

		System.out.println("weak reference" + weakRef.get());
		System.out.println("photom reference" + phantomRef.get());

		weakObj = null;
		phantomObj = null;
		System.gc();

		// See if the garbage collector has queued the references
		System.out.println("Weak Queued: " + weakRef.isEnqueued());
		// Try to finalize the phantom references if not already
		if (!phantomRef.isEnqueued()) {
			System.out.println("Requestion finalization.");
			System.runFinalization();
		}

		try {
			ref = weakQueue.remove();
			System.out.println("weak reference:" + ref.get());

			ref = phantomQueue.remove();
			System.out.println("phantom reference:" + ref.get());
			
			ref.clear();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}

	}
}
