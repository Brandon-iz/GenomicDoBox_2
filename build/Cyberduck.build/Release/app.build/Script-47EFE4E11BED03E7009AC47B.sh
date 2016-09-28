#!/bin/sh
if [ "${CONFIGURATION}" == 'Mac App Store' ]
then
rm -rf "${TARGET_BUILD_DIR}/${FRAMEWORKS_FOLDER_PATH}/Sparkle.framework"
fi
