# cordova-plugin-HostnameInfo

Define it in your module:
```javascript
function onSuccess(hostname) {
  $parameters.Success = true;
  $parameters.Hostname = hostname;
}

function onError(error) {
  $parameters.Success = false;
  $parameters.ErrorMessage = error;
}

hostnameinfo.getHostname(onSuccess, onError);
