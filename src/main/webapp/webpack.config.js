var webpack = require('webpack');
var CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");
var OpenBrowserPlugin = require('open-browser-webpack-plugin');

// var options = {
//     style: 'css',
//     libraryDirectory: 'lib',       // default: lib
//     libraryName: 'antd'            // default: antd
// };

module.exports = {
    entry: './main.jsx',
    output: {
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['', '.js', '.jsx'],
    },
    module: {
        loaders:[
            { test: /\.jsx$/, exclude: /node_modules/, loader: 'babel', query: {presets: ['es2015', 'react']}},
            { test: /\.js$/, exclude:/node_modules/, loader: 'babel', query: {
                presets: ['es2015', 'react']
            }},
            {
                test: /.less/,
                loader: 'style-loader!css-loader!less-loader'
            },
            { test: /\.css$/, loader: "style!css" }
        ]
    },
    babel: {
        plugins: [
            ["import", { libraryName: "antd", style: "css" }] // `style: true` 会加载 less 文件
        ],
    },
    plugins: [
        new CommonsChunkPlugin('init.js'),
        new OpenBrowserPlugin({ url: 'http://localhost:8080' })
    ]
};