package com.intellij.driver.model.transport;

import com.intellij.driver.model.LockSemantics;
import com.intellij.driver.model.OnDispatcher;
import com.intellij.driver.model.RdTarget;

import java.io.Serial;

public final class UtilityCall extends RemoteCall {
  @Serial
  private static final long serialVersionUID = 1L;

  public UtilityCall(int sessionId,
                     String timedSpan,
                     String pluginId,
                     OnDispatcher dispatcher,
                     LockSemantics lockSemantics,
                     String className,
                     String methodName,
                     RdTarget rdTarget,
                     Object[] args) {
    super(sessionId, timedSpan, pluginId, dispatcher, lockSemantics, className, methodName, rdTarget, args);
  }

  @Override
  public String toString() {
    return "UtilityCall{" +
           "className=" + getClassName() +
           " methodName=" + getMethodName() +
           '}';
  }
}
