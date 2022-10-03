const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const path = require("path");
const RemovePlugin = require("remove-files-webpack-plugin");
const TsconfigPathsPlugin = require("tsconfig-paths-webpack-plugin");

module.exports = {
    mode: "development",
    devtool: "inline-source-map",
    entry: {
        "main": "./src/ts/main.ts",
        "style": "./src/scss/style.scss",
    },
    output: {
        filename: "[name].js",
        path: path.resolve(__dirname, "../resources/static/js"),
    },
    module: {
        rules: [
            {
                test: /\.svg$/,
                use: [
                    {
                        loader: "svg-url-loader",
                        options: {
                            limit: 10000,
                        },
                    },
                ],
            },
            {
              test: /\.(png|jpe?g|gif)$/i,
              loader: 'file-loader',
              options: {
                name: '[name].[ext]',
                outputPath: '../images/',
              },
            },
            {
                test: /\.tsx?$/,
                loader: "ts-loader",
                options: {
                    configFile: "tsconfig.json",
                },
                exclude: /node_modules/,
            },
            {
                test: /\.s[ac]ss$/i,
                exclude: /node_modules/,
                use: [
                    {
                        loader: MiniCssExtractPlugin.loader,
                        options: {
                            reloadAll: true,
                        },
                    },
                    "css-loader",
                    {
                        loader: "postcss-loader",
                        options: {
                            config: {
                                path: "postcss.config.js",
                            },
                        },
                    },
                    {
                        loader: "sass-loader",
                        options: {
                            implementation: require("dart-sass"),
                        },
                    },
                ],
            },
          {
            test: /\.css$/,
            use: [
              { loader: MiniCssExtractPlugin.loader },
              { loader: 'css-loader', options: { importLoaders: 1 } }
            ]
          },
        ],
    },
    resolve: {
        extensions: [".ts", ".js", ".scss", ".css"],
        plugins: [new TsconfigPathsPlugin({configFile: "tsconfig.json"})],
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: "../css/[name].css",
        }),
        new RemovePlugin({
            after: {
                root: "../resources/static/js",
                include: [
                    "style.js",
                ],
                trash: true,
            },
        }),
    ],
};
