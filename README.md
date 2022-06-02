# ABOUT THIS REPOSITORY
openapi-generator-maven-plugin を用いて Spring アプリケーションの開発を Java で行うサンプルリポジトリです。このリポジトリを用いることで、以下を理解することが出来ます。
- Open API 定義のサンプル（GET/POST）
- openapi-generator-maven-plugin を用いた Spring for Java コードの自動生成（ディレクトリ変更含む）
- Docker Compose を用いた PostgreSQL の導入と接続
- flyway を用いた DB migration
- Spring Data JDBC を用いた CRUD 操作

# 環境・前提条件
## 開発端末
- macOS
  - Monterey：12.0.1（21A559）
  - Apple M1 Pro
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

# チュートリアル
## Open API 定義の確認

## Open API 定義を用いたソースコードの自動生成

## Spring API アプリケーションの作成・実行


# シチュエーション
## Open API 定義の修正とソースコードの自動生成
```
cd backend
```
```
mvn compile
```

## flyway による DB migration
```
cd backend
```
```
mvn flyway:migrate
```

## PostgreSQL 接続
```
psql -h db -U postgres
```
パスワードは pom.xml を参照して下さい

## Spring API アプリケーションのコンパイルから実行
