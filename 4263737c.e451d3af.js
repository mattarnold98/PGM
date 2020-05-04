(window.webpackJsonp=window.webpackJsonp||[]).push([[10],{149:function(e,t,n){"use strict";n.r(t),n.d(t,"frontMatter",(function(){return o})),n.d(t,"metadata",(function(){return i})),n.d(t,"rightToc",(function(){return b})),n.d(t,"default",(function(){return s}));var l=n(1),a=n(9),r=(n(0),n(172)),o={id:"tutorial",title:"Map Tutorial"},i={id:"modules/tutorial",title:"Map Tutorial",description:"The tutorial module is used to create a tutorial for the map. Tutorials are split up into stages which have a message and a teleport position.",source:"@site/docs/modules/tutorial.mdx",permalink:"/PGM/docs/modules/tutorial",editUrl:"https://github.com/Electroid/PGM/edit/docs/docs/modules/tutorial.mdx",sidebar:"Modules",previous:{title:"Includes & Conditionals",permalink:"/PGM/docs/modules/includes-conditionals"},next:{title:"Broadcasts",permalink:"/PGM/docs/modules/broadcasts"}},b=[],c={rightToc:b};function s(e){var t=e.components,n=Object(a.a)(e,["components"]);return Object(r.b)("wrapper",Object(l.a)({},c,n,{components:t,mdxType:"MDXLayout"}),Object(r.b)("p",null,"The tutorial module is used to create a tutorial for the map. Tutorials are split up into stages which have a message and a teleport position."),Object(r.b)("p",null,"Tutorials are intended for players with zero playing experience, thus they should be written as simple as possible, without any abbreviations or acronyms. If abbreviations are used it is recommended that they are explained or written out, e.g. ",Object(r.b)("inlineCode",{parentName:"p"},"Capture the Wool (CTW)")),Object(r.b)("p",null,"The ",Object(r.b)("inlineCode",{parentName:"p"},"tutorial.xml")," defines the default messages that will be sent at the beginning and end of the tutorial."),Object(r.b)("p",null,Object(r.b)("inlineCode",{parentName:"p"},"NOTE:")," This file ",Object(r.b)("strong",{parentName:"p"},"must")," be included."),Object(r.b)("p",null,Object(r.b)("inlineCode",{parentName:"p"},'<include src="tutorial.xml"/>')),Object(r.b)("p",null,"Tutorial stages contain a message with multiple lines and a teleport. A stage's title shouldn't be too long since it is displayed in the tool-tip of the tutorial item.\nThe message element can contain multiple lines, color and ",Object(r.b)("a",Object(l.a)({parentName:"p"},{href:"/reference/formatting"}),"formatting codes")," can be used for fancy text. Message lines are used to insert a hard line break, you can also put all the text into a single ",Object(r.b)("inlineCode",{parentName:"p"},"<line>")," however you won't have any control over where lines start to wrap."),Object(r.b)("p",null,"Teleports are optional, if they are not defined just the message will be displayed for that stage. They can contain ",Object(r.b)("a",Object(l.a)({parentName:"p"},{href:"/modules/regions"}),"regions")," or ",Object(r.b)("a",Object(l.a)({parentName:"p"},{href:"/modules/regions#pointProviders"}),"point providers"),", it is recommended that you use a point provider to control precisely where the player spawns. If a point is obstructed the player will not be teleported. However, the stage message will still be displayed."),Object(r.b)("p",null,"Stages are displayed in the order that they are defined as in the XML."),Object(r.b)("div",{className:"table-container"},Object(r.b)("table",null,Object(r.b)("thead",null,Object(r.b)("tr",null,Object(r.b)("th",null,"Tutorial Element"),Object(r.b)("th",null,"Description"),Object(r.b)("th",null))),Object(r.b)("tbody",null,Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"<tutorial> </tutorial>")),Object(r.b)("td",null,"Node containing all the defined tutorial stages."),Object(r.b)("td",null)),Object(r.b)("tr",null,Object(r.b)("th",null,"Sub-elements"),Object(r.b)("th",null),Object(r.b)("th",null,"Value/Children")),Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"<stage> </stage>")),Object(r.b)("td",null,"A single tutorial stage."),Object(r.b)("td",null,Object(r.b)("span",{className:"badge badge--default"},"Stage Sub-elements")))))),Object(r.b)("h5",{id:"tutorial-stage-attributes"},"Tutorial Stage Attributes"),Object(r.b)("div",{className:"table-container"},Object(r.b)("table",null,Object(r.b)("thead",null,Object(r.b)("tr",null,Object(r.b)("th",null,"Attribute"),Object(r.b)("th",null,"Description"),Object(r.b)("th",null,"Value"))),Object(r.b)("tbody",null,Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"title")),Object(r.b)("td",null,Object(r.b)("span",{className:"badge badge--danger"},"Required"),"Short title for this stage."),Object(r.b)("td",null,Object(r.b)("span",{className:"badge badge--primary"},"String")))))),Object(r.b)("h5",{id:"tutorial-stage-sub-elements"},"Tutorial Stage Sub-elements"),Object(r.b)("div",{className:"table-container"},Object(r.b)("table",null,Object(r.b)("thead",null,Object(r.b)("tr",null,Object(r.b)("th",null,"Element"),Object(r.b)("th",null,"Description"),Object(r.b)("th",null,"Value/Children"))),Object(r.b)("tbody",null,Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"<message>")),Object(r.b)("td",null,"Container for the tutorial message lines."),Object(r.b)("td",null,Object(r.b)("label",null,"<line>"))),Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"<line>")),Object(r.b)("td",null,"The message lines for this stage. Used in",Object(r.b)("label",null,"<message>")),Object(r.b)("td",null,Object(r.b)("span",{className:"badge badge--primary"},"String"))),Object(r.b)("tr",null,Object(r.b)("td",null,Object(r.b)("label",null,"<teleport>")),Object(r.b)("td",null,"The viewing location for this stage."),Object(r.b)("td",null,Object(r.b)("a",{href:"/modules/regions"},"Regions")))))),Object(r.b)("pre",null,Object(r.b)("code",Object(l.a)({parentName:"pre"},{className:"language-xml"}),'<tutorial>\n  <stage title="Capture the Wool">\n    <message>\n      <line>`rThis map is a `a`lCapture the Wool `r(CTW) map</line>\n      <line>The objective is to grab the wool on the other team\'s side and return it to your base.</line>\n    </message>\n    <teleport>\n        <point yaw="90" pitch="50">44,60,0</point>\n    </teleport>\n  </stage>\n  \x3c!-- next stages --\x3e\n</tutorial>\n')))}s.isMDXComponent=!0},172:function(e,t,n){"use strict";n.d(t,"a",(function(){return u})),n.d(t,"b",(function(){return O}));var l=n(0),a=n.n(l);function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(e);t&&(l=l.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,l)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){r(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function b(e,t){if(null==e)return{};var n,l,a=function(e,t){if(null==e)return{};var n,l,a={},r=Object.keys(e);for(l=0;l<r.length;l++)n=r[l],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(l=0;l<r.length;l++)n=r[l],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var c=a.a.createContext({}),s=function(e){var t=a.a.useContext(c),n=t;return e&&(n="function"==typeof e?e(t):i({},t,{},e)),n},u=function(e){var t=s(e.components);return a.a.createElement(c.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return a.a.createElement(a.a.Fragment,{},t)}},p=Object(l.forwardRef)((function(e,t){var n=e.components,l=e.mdxType,r=e.originalType,o=e.parentName,c=b(e,["components","mdxType","originalType","parentName"]),u=s(n),p=l,O=u["".concat(o,".").concat(p)]||u[p]||d[p]||r;return n?a.a.createElement(O,i({ref:t},c,{components:n})):a.a.createElement(O,i({ref:t},c))}));function O(e,t){var n=arguments,l=t&&t.mdxType;if("string"==typeof e||l){var r=n.length,o=new Array(r);o[0]=p;var i={};for(var b in t)hasOwnProperty.call(t,b)&&(i[b]=t[b]);i.originalType=e,i.mdxType="string"==typeof e?e:l,o[1]=i;for(var c=2;c<r;c++)o[c]=n[c];return a.a.createElement.apply(null,o)}return a.a.createElement.apply(null,n)}p.displayName="MDXCreateElement"}}]);