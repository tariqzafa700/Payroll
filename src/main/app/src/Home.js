import React, {Component} from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import FlatButton from "material-ui/FlatButton";
import TextField from "material-ui/TextField";
import logo from './logo.svg';
import './App.css';

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {greeting: undefined}
  }
  
  componentDidMount = () => {
    let username = 'user';
    let password = 'userPass';

    let headers = new Headers();
    headers.append("username",username);
    headers.append("password", password);
    fetch("/greet", {
      method: "GET",
      headers: headers,
      credentials: "same-origin"
    }).then(function(response) {
      let read = response.text();
      console.log("response.text()", read)
      return read;
    }).then((text) => {
      console.log("text is", text)
      this.setState({greeting: text, redirect: true});
    });
  }
  
  render = () => {
    return <MuiThemeProvider>
             <div> Welcome {this.state.greeting} </div>
           </MuiThemeProvider>
  }
}

export default Home;