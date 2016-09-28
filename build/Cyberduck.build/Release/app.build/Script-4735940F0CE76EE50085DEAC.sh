#!/bin/sh
find "${TARGET_BUILD_DIR}/${PRODUCT_NAME}.app/Contents/Resources" \( -name info.xib \) -type f -delete
find "${TARGET_BUILD_DIR}/${PRODUCT_NAME}.app/Contents/Resources" \( -name classes.xib \) -type f -delete
find "${TARGET_BUILD_DIR}/${PRODUCT_NAME}.app/Contents/Resources" \( -name data.dependency \) -type f -delete

