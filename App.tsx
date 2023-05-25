/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import {useState} from 'react';
import {
  Button,
  SafeAreaView,
  StatusBar,
  StyleSheet,
} from 'react-native';

import RTNFabricPlayer from 'rtn-fabric-player/src/RTNFabricPlayerNativeComponent';

function App(): JSX.Element {
  const [result, setResult] = useState<number | null>(null);

  /**
   * @param event
   */
  function onLog(event: any) {
    console.log("onLog", event.nativeEvent.message);
  }

  return (
    <SafeAreaView>
      <StatusBar barStyle={'dark-content'} />
      <RTNFabricPlayer 
        source="blah" 
        onLog={onLog}
        />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
});

export default App;
