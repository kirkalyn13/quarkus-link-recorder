package com.engrkirky.app.util;

import org.junit.jupiter.api.Test;

import static io.smallrye.common.constraint.Assert.assertFalse;
import static io.smallrye.common.constraint.Assert.assertTrue;

public class LinkUtilTest {
    @Test
    public void testIsValidHttpStatusCode() {
        // Valid HTTP status codes
        assertTrue(LinkUtil.isValidHttpStatusCode((short) 200));
        assertTrue(LinkUtil.isValidHttpStatusCode((short) 404));
        assertTrue(LinkUtil.isValidHttpStatusCode((short) 500));

        // Invalid HTTP status codes
        assertFalse(LinkUtil.isValidHttpStatusCode((short) 99)); // Below 100
        assertFalse(LinkUtil.isValidHttpStatusCode((short) 600)); // Above 599
    }
}
