package org.test.tests;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.test.tests.birthday", "org.test.tests.current.city", "org.test.tests.gender",
                    "org.test.tests.nativee.city", "org.test.tests.username"})
public class Autotests {}