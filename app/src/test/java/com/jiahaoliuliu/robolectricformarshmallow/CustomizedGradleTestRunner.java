package com.jiahaoliuliu.robolectricformarshmallow;

import com.jiahaoliuliu.robolectricformarshmallow.shadow.BaseActivityShadow;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.ClassInfo;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;
import org.robolectric.internal.bytecode.ShadowMap;

/**
 * Created by Jiahao on 7/17/16.
 */
public class CustomizedGradleTestRunner extends RobolectricGradleTestRunner {

    private static final List<String> CUSTOM_SHADOW_TARGETS = Collections.unmodifiableList(
        Arrays.asList("com.jiahaoliuliu.robolectricmarshmallow.BaseActivity"));

    public CustomizedGradleTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected ShadowMap createShadowMap() {
        return super.createShadowMap()
            .newBuilder().addShadowClass(BaseActivityShadow.class).build();
    }

    //@Override
    //public InstrumentationConfiguration createClassLoaderConfig(Config config) {
    //    InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
    //    builder.addInstrumentedClass(BaseActivityShadow.class.getName());
    //    return builder.withConfig(config).build();
    //}

    //@Override
    //public InstrumentationConfiguration createClassLoaderConfig() {
    //    InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
    //    builder.addInstrumentedPackage("com.jiahaoliuliu.robolectricformarshmallow");
    //    InstrumentationConfiguration instrumentationConfiguration =  builder.build();
    //    return instrumentationConfiguration;
    //}

    //private class InstrumentationConfig extends InstrumentationConfiguration {
    //
    //    @Override
    //    public boolean shouldInstrument(ClassInfo classInfo) {
    //        return super.shouldInstrument(classInfo);
    //    }
    //}
}
