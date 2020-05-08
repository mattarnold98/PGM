(window.webpackJsonp=window.webpackJsonp||[]).push([[45],{184:function(e,t,n){"use strict";n.r(t),n.d(t,"frontMatter",(function(){return o})),n.d(t,"metadata",(function(){return l})),n.d(t,"rightToc",(function(){return c})),n.d(t,"default",(function(){return s}));var a=n(1),r=n(9),i=(n(0),n(208)),o={id:"compiling-and-releasing",title:"Compiling and Releasing"},l={id:"guides/packaging/compiling-and-releasing",title:"Compiling and Releasing",description:"Once your world is cleaned up and pruned, it is ready to be compiled. To start, add in your `map.xml` file. Then, add in your `map.png` file. Below is an image of what your folder should look like:",source:"@site/docs/guides/packaging/compiling-and-releasing.mdx",permalink:"/docs/guides/packaging/compiling-and-releasing",editUrl:"https://github.com/Electroid/PGM/edit/docs/docs/guides/packaging/compiling-and-releasing.mdx",sidebar:"Guides",previous:{title:"Pruning Chunks",permalink:"/docs/guides/packaging/pruning-chunks"},next:{title:"Help Us Migrate Past Files!",permalink:"/docs/guides/contribute/migrate"}},c=[],p={rightToc:c};function s(e){var t=e.components,n=Object(r.a)(e,["components"]);return Object(i.b)("wrapper",Object(a.a)({},p,n,{components:t,mdxType:"MDXLayout"}),Object(i.b)("p",null,"Once your world is cleaned up and pruned, it is ready to be compiled. To start, add in your ",Object(i.b)("inlineCode",{parentName:"p"},"map.xml")," file. Then, add in your ",Object(i.b)("inlineCode",{parentName:"p"},"map.png")," file. Below is an image of what your folder should look like:"),Object(i.b)("p",null,Object(i.b)("img",Object(a.a)({parentName:"p"},{src:"https://i.imgur.com/BZ1ihzE.png",alt:null}))),Object(i.b)("h4",{id:"the-maps-xml-file"},"The Map's XML File"),Object(i.b)("p",null,"The ",Object(i.b)("inlineCode",{parentName:"p"},"map.xml")," file is the XML you coded for your map. This file is essential when it comes to having your map loaded and tested. While you may submit maps without this file, it means someone else will have to code all the gameplay for your map. This makes your map less likely to be tested or used at all."),Object(i.b)("p",null,"Also, take note of the following coding guidelines when creating your ",Object(i.b)("inlineCode",{parentName:"p"},"map.xml")," file:"),Object(i.b)("ul",null,Object(i.b)("li",{parentName:"ul"},"Verify there are ",Object(i.b)("strong",{parentName:"li"},"no tabs in the XML")," -- 4 spaces only"),Object(i.b)("li",{parentName:"ul"},"Verify the main map element and its main elements are not indented"),Object(i.b)("li",{parentName:"ul"},"Follow ",Object(i.b)("a",Object(a.a)({parentName:"li"},{href:"http://semver.org"}),"Semantic Versioning")," when deciding the map version"),Object(i.b)("li",{parentName:"ul"},"Bump the map version if gameplay has changed"),Object(i.b)("li",{parentName:"ul"},Object(i.b)("a",Object(a.a)({parentName:"li"},{href:"http://www.w3schools.com/xml/xml_validator.asp"}),"Validate")," the XML to make sure it does not have any syntax errors")),Object(i.b)("h4",{id:"the-map-image"},"The Map Image"),Object(i.b)("p",null,"The ",Object(i.b)("inlineCode",{parentName:"p"},"map.png")," file displays the image of your map on the website. The standard resolution for these pictures is ",Object(i.b)("inlineCode",{parentName:"p"},"290x246"),". This image should contain a general overview of the map's playing area."),Object(i.b)("p",null,"Image Example"),Object(i.b)("div",{className:"row"},Object(i.b)("div",{className:"col col--6"},Object(i.b)("img",{src:"https://i.imgur.com/7BrMIPA.png"})),Object(i.b)("div",{className:"col"},Object(i.b)("img",{src:"https://i.imgur.com/On5orcO.png"}))),Object(i.b)("h4",{id:"compressing-the-folder-to-a-zip-file"},"Compressing the folder to a ZIP file"),Object(i.b)("p",null,"Before you upload the map, you must compress the folder to a ",Object(i.b)("inlineCode",{parentName:"p"},".zip")," format. Do ",Object(i.b)("strong",{parentName:"p"},"not")," compress to a ",Object(i.b)("inlineCode",{parentName:"p"},".rar")," or any other format."),Object(i.b)("p",null,"To compress a folder:"),Object(i.b)("ul",null,Object(i.b)("li",{parentName:"ul"},Object(i.b)("inlineCode",{parentName:"li"},"Windows:")," Right Click > Send To > Compressed Zip"),Object(i.b)("li",{parentName:"ul"},Object(i.b)("inlineCode",{parentName:"li"},"Mac"),": Right Click > Compress")),Object(i.b)("h4",{id:"uploading-the-map"},"Uploading the map"),Object(i.b)("p",null,"To upload the map, we recommend using ",Object(i.b)("a",Object(a.a)({parentName:"p"},{href:"https://www.mediafire.com/"}),"MediaFire")," or ",Object(i.b)("a",Object(a.a)({parentName:"p"},{href:"https://www.dropbox.com/"}),"Dropbox"),"."))}s.isMDXComponent=!0},208:function(e,t,n){"use strict";n.d(t,"a",(function(){return m})),n.d(t,"b",(function(){return d}));var a=n(0),r=n.n(a);function i(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function l(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){i(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function c(e,t){if(null==e)return{};var n,a,r=function(e,t){if(null==e)return{};var n,a,r={},i=Object.keys(e);for(a=0;a<i.length;a++)n=i[a],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(a=0;a<i.length;a++)n=i[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}var p=r.a.createContext({}),s=function(e){var t=r.a.useContext(p),n=t;return e&&(n="function"==typeof e?e(t):l({},t,{},e)),n},m=function(e){var t=s(e.components);return r.a.createElement(p.Provider,{value:t},e.children)},u={inlineCode:"code",wrapper:function(e){var t=e.children;return r.a.createElement(r.a.Fragment,{},t)}},b=Object(a.forwardRef)((function(e,t){var n=e.components,a=e.mdxType,i=e.originalType,o=e.parentName,p=c(e,["components","mdxType","originalType","parentName"]),m=s(n),b=a,d=m["".concat(o,".").concat(b)]||m[b]||u[b]||i;return n?r.a.createElement(d,l({ref:t},p,{components:n})):r.a.createElement(d,l({ref:t},p))}));function d(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var i=n.length,o=new Array(i);o[0]=b;var l={};for(var c in t)hasOwnProperty.call(t,c)&&(l[c]=t[c]);l.originalType=e,l.mdxType="string"==typeof e?e:a,o[1]=l;for(var p=2;p<i;p++)o[p]=n[p];return r.a.createElement.apply(null,o)}return r.a.createElement.apply(null,n)}b.displayName="MDXCreateElement"}}]);