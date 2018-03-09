#!/usr/bin/env bash

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
else
  echo "Uploading build to Bintray..."
  ./gradlew clean bintrayUpload
  echo "Build uploaded!"
fi