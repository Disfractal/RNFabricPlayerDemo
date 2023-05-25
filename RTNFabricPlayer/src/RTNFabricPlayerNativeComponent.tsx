import type { ViewProps } from 'react-native/Libraries/Components/View/ViewPropTypes';
import type {HostComponent} from 'react-native';
import {Platform} from 'react-native';
import type {
  Float,
  Double,
  Int32,
  BubblingEventHandler,
} from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';


type LogEvent = {
  // target: Int32,
  message: string,
};

export interface NativeProps extends ViewProps {
  source?: string;
  onLog?: BubblingEventHandler<LogEvent>;
}

export default codegenNativeComponent<NativeProps>(
  'RTNFabricPlayer',
) as HostComponent<NativeProps>;