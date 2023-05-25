#!/bin/sh
yarn add ./RTNFabricPlayer
cd android
./gradlew generateCodegenArtifactsFromSchema
cd ..
watchman watch-del '/Users/user/Desktop/RNFabricPlayerDemo' ; watchman watch-project '/Users/user/Desktop/RNFabricPlayerDemo'
# npx react-native run-android
npm start