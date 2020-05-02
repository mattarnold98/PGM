(window.webpackJsonp=window.webpackJsonp||[]).push([[15],{155:function(e,t,n){"use strict";n.r(t),n.d(t,"frontMatter",(function(){return i})),n.d(t,"metadata",(function(){return s})),n.d(t,"rightToc",(function(){return c})),n.d(t,"default",(function(){return b}));var r=n(1),o=n(9),a=(n(0),n(162)),i={id:"regions",title:"Defining Regions"},s={id:"guides/regions",title:"Defining Regions",description:"First of all, region coordinates in PGM are _real numbers_. That means they can be fractional values, like 2.3, 4.5, 6.789, and so on. A coordinate represents a _point_ on one of the three axes (X, Y, or Z), and a set of three coordinates represents a _point_ in 3D space. Coordinates do **not** represent blocks, at least not _directly_. When PGM needs to decide if a block is inside a region, it checks if the point at the **center** of the block is inside the region. The center point of a block will always have coordinates that end in `.5`. When making regions, you have to make sure that all the block centers are _inside_ the region.",source:"@site/docs/guides/regions.mdx",permalink:"/PGM/docs/guides/regions",editUrl:"https://github.com/Electroid/PGM/edit/docs/docs/guides/regions.mdx",sidebar:"Guides",next:{title:"Help Us Migrate Past Files!",permalink:"/PGM/docs/guides/migrate"}},c=[{value:"Regions: The Wrong Way",id:"regions-the-wrong-way",children:[]}],l={rightToc:c};function b(e){var t=e.components,n=Object(o.a)(e,["components"]);return Object(a.b)("wrapper",Object(r.a)({},l,n,{components:t,mdxType:"MDXLayout"}),Object(a.b)("p",null,"First of all, region coordinates in PGM are ",Object(a.b)("em",{parentName:"p"},"real numbers"),". That means they can be fractional values, like 2.3, 4.5, 6.789, and so on. A coordinate represents a ",Object(a.b)("em",{parentName:"p"},"point")," on one of the three axes (X, Y, or Z), and a set of three coordinates represents a ",Object(a.b)("em",{parentName:"p"},"point")," in 3D space. Coordinates do ",Object(a.b)("strong",{parentName:"p"},"not")," represent blocks, at least not ",Object(a.b)("em",{parentName:"p"},"directly"),". When PGM needs to decide if a block is inside a region, it checks if the point at the ",Object(a.b)("strong",{parentName:"p"},"center")," of the block is inside the region. The center point of a block will always have coordinates that end in ",Object(a.b)("inlineCode",{parentName:"p"},".5"),". When making regions, you have to make sure that all the block centers are ",Object(a.b)("em",{parentName:"p"},"inside")," the region."),Object(a.b)("p",null,"Here is an example. Let's say we want to make region for a destroyable that looks like this:"),Object(a.b)("p",null,Object(a.b)("img",Object(r.a)({parentName:"p"},{src:"https://i.imgur.com/q9NMNuV.png",alt:null}))),Object(a.b)("p",null,"First, we stand very close to one ",Object(a.b)("strong",{parentName:"p"},"corner")," of the region and note the coordinates are ",Object(a.b)("inlineCode",{parentName:"p"},"(32, 60, -20)"),":"),Object(a.b)("p",null,Object(a.b)("img",Object(r.a)({parentName:"p"},{src:"https://i.imgur.com/OzvGnlJ.png",alt:null}))),Object(a.b)("p",null,"Then we stand over the opposite corner and note the coordinates are ",Object(a.b)("inlineCode",{parentName:"p"},"(34, 60, -18)"),".",Object(a.b)("br",null)," We know the monument is three blocks tall, so we'll just subtract three from the Y coordinate to get ",Object(a.b)("inlineCode",{parentName:"p"},"(34, 57, -18)"),":"),Object(a.b)("p",null,Object(a.b)("img",Object(r.a)({parentName:"p"},{src:"https://i.imgur.com/mNeLmU8.png",alt:null}))),Object(a.b)("p",null,"Notice that we are rounding to the  ",Object(a.b)("strong",{parentName:"p"},"nearest")," integer, since those will obviously be the coordinates of the corner we are standing close to. We don't need to worry about positive vs negative coordinates, as they work the same way, and we never need to add or subtract one."),Object(a.b)("p",null,"With these coordinates, we can make a cuboid region for the monument:"),Object(a.b)("pre",null,Object(a.b)("code",Object(r.a)({parentName:"pre"},{className:"language-xml"}),'<cuboid min="32, 60, -20" max="34, 57, -18"/>\n')),Object(a.b)("p",null,"For style points, we can make sure all the low coordinates are in min and the high ones in max:"),Object(a.b)("pre",null,Object(a.b)("code",Object(r.a)({parentName:"pre"},{className:"language-xml"}),'<cuboid min="32, 57, -20" max="34, 60, -18"/>\n')),Object(a.b)("p",null,"This is not necessary, as PGM will fix it for you, but it might make the XML easier for a human to read and edit."),Object(a.b)("p",null,"An easy way to check that cuboid regions are correct is to simply subtract the low coordinates from the high ones. The result should be the size of the region. If it isn't, you did something wrong."),Object(a.b)("p",null,"Let's try a more interesting region: a cylinder. A cylinder is defined by its base (center) point, radius, and height. Assuming one layer of blocks, the cylinder in the image below is based at ",Object(a.b)("inlineCode",{parentName:"p"},"(53.5, 57, -10.5)")," and has a radius of ",Object(a.b)("inlineCode",{parentName:"p"},"2.5")," and a height of ",Object(a.b)("inlineCode",{parentName:"p"},"1"),". Blocks with their center point inside the cylinder will be considered part of the region. I've highlighted the region boundary and the block centers so you can easily see how this works:"),Object(a.b)("p",null,Object(a.b)("img",Object(r.a)({parentName:"p"},{src:"https://i.imgur.com/OgME3KK.png",alt:null}))),Object(a.b)("p",null,"So the region would be:"),Object(a.b)("pre",null,Object(a.b)("code",Object(r.a)({parentName:"pre"},{className:"language-xml"}),'<cylinder base="53.5, 57, -10.5" radius="2.5" height="1"/>\n')),Object(a.b)("h3",{id:"regions-the-wrong-way"},"Regions: The Wrong Way"),Object(a.b)("p",null,"I know that many of you are using WorldEdit to get region coordinates, and my advice to you is ",Object(a.b)("strong",{parentName:"p"},"DON'T")," . WorldEdit uses a dumb coordinate system that will not give you correct regions, and while it's possible to convert the coordinates, it's going to confuse you and cause mistakes, and it's just not worth the trouble. I suspect that WorldEdit is the reason we have so many region errors in our map collection right now."))}b.isMDXComponent=!0},162:function(e,t,n){"use strict";n.d(t,"a",(function(){return p})),n.d(t,"b",(function(){return h}));var r=n(0),o=n.n(r);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function s(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function c(e,t){if(null==e)return{};var n,r,o=function(e,t){if(null==e)return{};var n,r,o={},a=Object.keys(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var l=o.a.createContext({}),b=function(e){var t=o.a.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):s({},t,{},e)),n},p=function(e){var t=b(e.components);return o.a.createElement(l.Provider,{value:t},e.children)},d={inlineCode:"code",wrapper:function(e){var t=e.children;return o.a.createElement(o.a.Fragment,{},t)}},u=Object(r.forwardRef)((function(e,t){var n=e.components,r=e.mdxType,a=e.originalType,i=e.parentName,l=c(e,["components","mdxType","originalType","parentName"]),p=b(n),u=r,h=p["".concat(i,".").concat(u)]||p[u]||d[u]||a;return n?o.a.createElement(h,s({ref:t},l,{components:n})):o.a.createElement(h,s({ref:t},l))}));function h(e,t){var n=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var a=n.length,i=new Array(a);i[0]=u;var s={};for(var c in t)hasOwnProperty.call(t,c)&&(s[c]=t[c]);s.originalType=e,s.mdxType="string"==typeof e?e:r,i[1]=s;for(var l=2;l<a;l++)i[l]=n[l];return o.a.createElement.apply(null,i)}return o.a.createElement.apply(null,n)}u.displayName="MDXCreateElement"}}]);