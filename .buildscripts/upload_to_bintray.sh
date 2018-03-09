#!/bin/bash

SLUG="constantcontact/java-sdk"
JDK="oraclejdk8"
BRANCH="master"

set -e
if [ "$TRAVIS_REPO_SLUG" != "$SLUG" ]; then
  echo "Skipping upload: wrong repository. Expected '$SLUG' but was '$TRAVIS_REPO_SLUG'."
elif [ "$TRAVIS_JDK_VERSION" != "$JDK" ]; then
  echo "Skipping upload: wrong JDK. Expected '$JDK' but was '$TRAVIS_JDK_VERSION'."
elif [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  echo "Skipping upload: was pull request."
elif [ "$TRAVIS_BRANCH" != "$BRANCH" ]; then
  echo "Skipping upload: wrong branch. Expected '$BRANCH' but was '$TRAVIS_BRANCH'."
elif [ -z "$BINTRAY_USER" ]; then
  echo "Skipping upload: Expected BINTRAY_USER to be set."
elif [ -z "$BINTRAY_KEY" ]; then
  echo "Skipping upload: Expected BINTRAY_KEY to be set."
else
  echo "Uploading build to Bintray..."
  ./gradlew clean bintrayUpload -Prelease=true
  echo "Build uploaded!"
fi