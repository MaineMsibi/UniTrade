import React from 'react';

import { DashboardLinks } from './DashboardLinks';

const Dashboard = () => {
    return (
        <div className="Sidebar">
            <ul className ="SidebarList">
                {DashboardLinks.map((val, key) => {
                    return (
                        <li
                            key = {key}
                            className = "row"
                            id = {window.location.pathname == val.link? "active": ""}
                            onClick = {()=>{
                                window.location.pathname = val.link;
                            }}
                        >
                            <div id="icon">{val.icon}</div><div id ="title">{val.title}</div>
                        </li>
                    );
                })};    
            </ul>
        </div>
    );
}

export default Dashboard;