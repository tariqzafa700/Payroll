import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link, Redirect } from "react-router-dom";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import FlatButton from "material-ui/FlatButton";
import TextField from "material-ui/TextField";
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {greeting: "", view: "Login", username: "", password: ""}
  }
  
  componentDidMount() {
    
  }
  
  onChangeUsername = (evt, str) => {
    this.setState({username: str});
  }
  
  onChangePassword = (evt, str) => {
    this.setState({password: str});
  }

  onCreateAccount = () => {
    this.setState({view:"Create Account"})
  }
  
  onLogin = () => {
    this.setState({view:"Login"})
  }
 
  onSubmit = () => {
    if(this.state.view === "Login") {
      let username = 'user';
      let password = 'userPass';

      let headers = new Headers();

      //headers.append('Authorization', 'Basic ' + btoa(username + ":" + password));
      /*fetch("/greet", {method:'GET',
        headers: headers,
        //credentials: 'user:userPass'
       }).then(function(response) {
             return response.text();
          }).then((text) => {
                this.setState({greeting: text, redirect: true});
             });*/
      headers.append("username",username);
      headers.append("password", password);
      fetch("/login?username="+username+"&password="+password, {
        method: "POST",
        headers: headers,
        credentials: "same-origin"
      }).then(function(response) {
        return response.text();
      }).then((text) => {
            this.setState({greeting: text, redirect: true});
         });

    } else {
      let url = '/greet';
      let username = 'user';
      let password = 'userPass';

      let headers = new Headers();

      headers.append('Authorization', 'Basic ' + btoa(username + ":" + password));

      fetch(url, {method:'GET',
              headers: headers,
             })
      .then(response => response.json())
      .then(json => console.log(json));
    }
  }
  
  render() {
    if(this.state.redirect) {
      
      return 
      <Redirect push to="/home" />
     
    }
    return (
      <Router>
      <MuiThemeProvider>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">{this.state.greeting}</h1>
        </header>
        <div className="App-intro">
        <form onSubmit={this.onSubmit}>
          <div style={{display:"flex", flexDirection: "column", alignItems: "center"}}>
          <p>{this.state.view}</p>
          <TextField hintText="Username" onChange={this.onChangeUsername}/>
          <TextField hintText="Password" onChange={this.onChangePassword}/>
          <FlatButton label="Submit" style={{color:"white", backgroundColor: "purple", marginTop: 10}}  
            onClick={this.onSubmit}
            //containerElement={<Link to={{       pathname: '/home'}}/>}
          
          />
          {this.state.view !== "Create Account"?
              <FlatButton label="Create a new account" style={{color:"purple", marginTop: 10}} onClick={this.onCreateAccount}/>
              : 
              <FlatButton label="Log in to existing account" style={{color:"purple", marginTop: 10}} />
          }
          </div>
          </form>
        </div>
      </div>
      <Route path="/home" component={Home} />
      </MuiThemeProvider>
    </Router>
    );
  }
}

const Home = props => {

  return (<h2>Welcome to home!!</h2>
  );
}
  
  


export default App;
