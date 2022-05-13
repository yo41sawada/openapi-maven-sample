# ABOUT THIS REPOSITORY
openapi-generator-maven-plugin を用いて Spring アプリケーションの開発を Java で行うサンプルリポジトリです。このリポジトリを用いることで、以下を理解することが出来ます。
- Open API 定義を用いた Spring for Java コードの自動生成
- openapi-generator-maven-plugin の基本的な用法
- hoge
- piyo
- fuga

# 環境・前提条件
## 開発端末
- macOS
  - Monterey：12.0.1（21A559）
  - Apple M1 Pro
- Java：OpenJDK 11.0.14
  - JAVA_HOME を追加
  - PATH への追加は必須ではない
- Maven：3.8.5
  - PATH へ追加
- Visual Studio Code：1.67.1 (Universal)
  - Extension Pack for Java
    - Language support for Java (TM) by Red Hat
    - Debugger for Java
    - Test Runner for Java
    - Maven for Java
    - Project Manager for Java
    - IntelliCode
  - Checkstyle for Java
  - SonarLint

# セットアップ
## GitHub
```
git clone https://github.com/yo41sawada/openapi-maven-sample.git
```
## Visual Studio Code
- クローンしたディレクトリの Open
- settings.json への maven 実行パスの追加
  ```
  "maven.executable.path": "/{your Maven directory}/bin/mvn"
  ```

## Open API 定義の準備と openapi-generator-maven-plugin を用いたソースコードの自動生成
```
cd "/{your working directory}/openapi-maven-sample"
mvn clean compile
```

# ビルド・コンパイル・実行
あああ