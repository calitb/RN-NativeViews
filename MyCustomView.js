// @flow
import React from 'react';
import { requireNativeComponent } from 'react-native';

type Props = {
  status: Boolean,
  onClick: Function
}

const RCTCustomView = requireNativeComponent('RCTMyCustomView', MyCustomView, {});

class MyCustomView extends React.PureComponent<Props> {
  _onClick = (event) => {
    if (!this.props.onClick) {
      return;
    }

    // process raw event...
    this.props.onClick(event.nativeEvent);
  }

  render() {
    return <RCTCustomView {...this.props} onClick={this._onClick}/>
  }
}

export default MyCustomView;
