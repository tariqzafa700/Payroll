import React, {Component} from "react";
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Login from "./Login";
import Home from "./Home";

const AppRouter = props => {
  return <Router>
  <Switch>
    <Route exact path="/home" component={Home}/>
    <Route exact path="/login" render={(routeProps) => {return <Login {...routeProps} view={"Login"}/>}}/>
    <Route path="/createAccount" render={(routeProps) => {return <Login {...routeProps} view={"Create Account"}/>}}/>
  </Switch>
  </Router>
}

export default AppRouter;
